package se.umu.cs.peer0019.pocketaid.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import se.umu.cs.peer0019.pocketaid.ExpensesListAdapter
import se.umu.cs.peer0019.pocketaid.R
import se.umu.cs.peer0019.pocketaid.db.AppDatabase
import se.umu.cs.peer0019.pocketaid.models.AggregatedExpense


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
        return inflater.inflate(R.layout.fragment_expenses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fetch data
        val db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "expenses"
        )
            .allowMainThreadQueries()
            .build()
        val ed = db.expenseDao()
        val dbExpenses = ed.getExpensesByDateDesc()
        val categories = ed.getCategories()

        // Prepare aggregated expenses also including category name
        val expenses = mutableListOf<AggregatedExpense>()

        dbExpenses.forEach { expense ->
            val category = categories.find {
                it.id == expense.categoryId
            }
            val categoryName = if (category != null) category.name else ""
            expenses.add(AggregatedExpense(
                expense.id,
                expense.place,
                expense.description,
                expense.categoryId,
                categoryName,
                expense.date,
                expense.amount
            ))
        }

        val a = view.findViewById<RecyclerView>(R.id.expenses_recyclerview)
        a.layoutManager = LinearLayoutManager(activity)
        a.adapter = ExpensesListAdapter(expenses)
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