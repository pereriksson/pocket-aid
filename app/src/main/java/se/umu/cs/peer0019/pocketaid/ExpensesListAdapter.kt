package se.umu.cs.peer0019.pocketaid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import se.umu.cs.peer0019.pocketaid.models.Expense
import kotlin.math.exp

class ExpensesListAdapter : RecyclerView.Adapter<ExpensesListAdapter.ViewHolder>() {
    private var expenses: List<Expense> = mutableListOf(
        Expense(1, "place", "desc", 1, "2022-01-02", 100),
        Expense(1, "place", "desc", 1, "2022-01-02", 100),
        Expense(1, "place", "desc", 1, "2022-01-02", 100),
        Expense(1, "place", "desc", 1, "2022-01-02", 100),
        Expense(1, "place", "desc", 1, "2022-01-02", 100),
        Expense(1, "place", "desc", 1, "2022-01-02", 100),
        Expense(1, "place", "desc", 1, "2022-01-02", 100)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_expense, parent, false)
        return ViewHolder(v)
    }

    /**
     * Populates data into the individual card view.
     */
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        println("onBindViewHolder")
        viewHolder.placeItemView.text = expenses[i].place
        viewHolder.dateItemView.text = expenses[i].date
        viewHolder.categoryNameItemView.text = expenses[i].categoryId.toString() // todo
        viewHolder.amountItemView.text = expenses[i].amount.toString()

    }

    override fun getItemCount(): Int {
        println("expenses.size "+expenses.size.toString())
        return expenses.size
    }

    /**
     * Each individual element in the list is defined by a view holder object.
     */
    class ViewHolder(
        itemView: View
        ) : RecyclerView.ViewHolder(itemView) {
        var placeItemView: TextView
        var dateItemView: TextView
        var categoryNameItemView: TextView
        var amountItemView: TextView


        var data: Expense? = null

        init {
            placeItemView = itemView.findViewById(R.id.expenses_list_item_place)
            dateItemView = itemView.findViewById(R.id.expenses_list_item_date)
            categoryNameItemView = itemView.findViewById(R.id.expenses_list_item_category_name)
            amountItemView = itemView.findViewById(R.id.expenses_list_item_amount)

        }

        fun bind(item: Expense?) {
            // assign it to `data` so it can be used with `setOnClickListener`
            data = item
            placeItemView.text = item?.place
            dateItemView.text = item?.date
            // todo
            categoryNameItemView.text = item?.categoryId.toString()
            amountItemView.text = item?.amount.toString()
        }

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_expense, parent, false)
                return ViewHolder(view)
            }
        }
    }

    companion object {
        private val EXPENSES_COMPARATOR = object : DiffUtil.ItemCallback<Expense>() {
            override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
                return oldItem === newItem
            }

            // todo: ?
            override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
