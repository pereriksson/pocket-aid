package se.umu.cs.peer0019.pocketaid.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import se.umu.cs.peer0019.pocketaid.R
import se.umu.cs.peer0019.pocketaid.databinding.FragmentSettingsBinding
import se.umu.cs.peer0019.pocketaid.db.AppDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    private lateinit var dataBinding: FragmentSettingsBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        return dataBinding.root
    }

    fun createDemoData(context: Context) {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "expenses"
        )
            .allowMainThreadQueries() // TODO: DO NOT fetch on main thread
            .build()
        val ed = db.expenseDao()

        ed.deleteExpenses()
        ed.deleteCategories()

        ed.insertCategory("Residence", "#00FDFF")
        ed.insertExpense("Skandia", "Interest", 1, "2022-01-02", 4950)
        ed.insertExpense("Skandia", "Amortization", 1, "2022-01-02", 2775)
        ed.insertExpense("BRF Lindhagens Backe", "Monthly fee", 1, "2022-01-02", 2973)

        ed.insertCategory("Food", "#05129C")
        ed.insertExpense("ICA MAXI Stormarknad", "Food", 2, "2022-01-02", 589)
        ed.insertExpense("Espresso House", "Fika with Erik", 2, "2022-01-02", 159)
        ed.insertExpense("Espresso House", "Fika with Anna", 2, "2022-01-02", 49)
        ed.insertExpense("Pressbyr??n", "Breakfast", 2, "2022-01-02", 29)
        ed.insertExpense("Ciao Ciao", "Dinner", 2, "2022-01-02", 439)

        ed.insertCategory("Electronics", "#17E883")
        ed.insertExpense("Media Markt", "SONOS One Gen2 White", 3, "2022-01-02", 2549)

        ed.insertCategory("Travel", "#2C95F1")
        ed.insertExpense("Norwegian", "Stockholm-Berlin", 4, "2022-01-02", 5691)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val createDemoDataBtn = dataBinding.createDemoData

        createDemoDataBtn.setOnClickListener {
            // todo: Figure out how to do with context in fragments
            createDemoData(requireContext())
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}