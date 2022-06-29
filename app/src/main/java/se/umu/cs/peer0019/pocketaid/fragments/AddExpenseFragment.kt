package se.umu.cs.peer0019.pocketaid.fragments

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import se.umu.cs.peer0019.pocketaid.R
import se.umu.cs.peer0019.pocketaid.db.AppDatabase
import java.io.File
import se.umu.cs.peer0019.pocketaid.databinding.FragmentAddExpenseBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddExpenseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddExpenseFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var expenseImageTempFilename = "newExpense.jpg"

    private lateinit var dataBinding: FragmentAddExpenseBinding

    val launcher=registerForActivityResult<Uri,Boolean>(ActivityResultContracts.TakePicture()) {
        if(it) {
            //Bilden sparad till den plats vi angav i intentetIntent. Bilden kommer bytas ut
            //Då aktiviteten blir synlig
            // todo: ugly...
            view?.let { view ->
                val expenseImage = view.findViewById(R.id.expenseImage) as ImageView
                activity?.let { activity ->
                    val file = File(activity.filesDir, expenseImageTempFilename)
                    // TODO: EXIF orientation adjustment
                    val bitmap = BitmapFactory.decodeFile(file.absolutePath)
                    expenseImage.setImageBitmap(bitmap)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_add_expense)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_expense, container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val takeBtn = view.findViewById<Button>(R.id.takePicture)
        takeBtn.setOnClickListener {
            takePicture()
        }
        val addExpenseBtn = view.findViewById<Button>(R.id.addExpenseBtn)

        addExpenseBtn.setOnClickListener {
            // TODO: Copy image to permanent store
            val db = Room.databaseBuilder(
                requireContext(),
                AppDatabase::class.java, "expenses"
            )
                .allowMainThreadQueries()
                .build()
            val ed = db.expenseDao()

            // TODO: Maybe require an amount in the UI instead?
            var amount = 0
            val userAmount = view.findViewById<TextView>(R.id.expenseAmount).text.toString()
            if (userAmount.isNotEmpty()) {
                amount = Integer.parseInt(view.findViewById<TextView>(R.id.expenseAmount).text.toString())
            }

            ed.insertExpense(
                view.findViewById<TextView>(R.id.expensePlace).text.toString(),
                view.findViewById<TextView>(R.id.expenseDescription).text.toString(),
                1, // TODO: Hard coded
                view.findViewById<TextView>(R.id.expenseDate).text.toString(),
                amount
            )

            // Delete image file (if any)
            val file = File(requireContext().filesDir, expenseImageTempFilename)
            file.exists() && file.delete()
            val expenseImage = view.findViewById(R.id.expenseImage) as ImageView
            expenseImage.setImageResource(R.drawable.ic_image)

            // Reset form
            view.findViewById<TextView>(R.id.expensePlace).text = ""
            view.findViewById<TextView>(R.id.expenseDescription).text = ""
            view.findViewById<TextView>(R.id.expenseDate).text = ""
            view.findViewById<TextView>(R.id.expenseAmount).text = ""

            // Navigate to expenses list
            findNavController().navigate(R.id.expensesFragment)
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun takePicture() {
        /* Bestäm vart filen ska sparas
         * Observera att Kamera-appen måste kunna skriva till platsen
         * där filen finns därav används en FileProvider
         */
        val uri: Uri

        //Spara filen i vår local
        // storage med en content-url. Det låter de oss spara filen var som helst utan att behöva
        // bry os om att kameraappen har rättighet at skriva dit. Dessutom har vi
        // om vi sparar filen på ett ställe vi har koll på kontroll över att ingen
        // annan app sabbar något

        activity?.let {
            val file = File(it.filesDir, expenseImageTempFilename)
            uri = FileProvider.getUriForFile(it.applicationContext, "${it.packageName}.fileprovider", file!!)
            launcher.launch(uri)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddExpenseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddExpenseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}