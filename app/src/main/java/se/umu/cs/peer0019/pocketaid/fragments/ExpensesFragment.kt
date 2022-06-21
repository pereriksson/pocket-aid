package se.umu.cs.peer0019.pocketaid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import se.umu.cs.peer0019.pocketaid.ExpensesListAdapter
import se.umu.cs.peer0019.pocketaid.R
import se.umu.cs.peer0019.pocketaid.db.Db


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExpensesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExpensesFragment : Fragment() {
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
        /*val transaction = childFragmentManager.beginTransaction()
        val expenseGroup = ExpenseGroupFragment()
        transaction.add(R.id.fragment_scroll_view, expenseGroup)
        val expense = ExpenseFragment()
        transaction.add(R.id.fragment_scroll_view, expense)
        transaction.commit()*/

        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        //val view: View = inflater.inflate(se.umu.cs.peer0019.pocketaid.R.layout.fragment_expenses, container, false)



        // todo: bör jag hömta data här?
//        val recyclerView = view?.findViewById<RecyclerView>(se.umu.cs.peer0019.pocketaid.R.id.expenses_recyclerview)
//        val adapter = ExpensesListAdapter()
//        context?.let {
//            adapter.expenses = Db(it).getExpenses()
//        }
//
//        recyclerView?.adapter = adapter
//        recyclerView?.layoutManager = LinearLayoutManager(context)

        val view = inflater.inflate(R.layout.fragment_expenses, container, false)
        val a = view.findViewById<RecyclerView>(R.id.expenses_recyclerview)
        a.layoutManager = LinearLayoutManager(activity)
        a.adapter = ExpensesListAdapter()
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ExpensesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExpensesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}