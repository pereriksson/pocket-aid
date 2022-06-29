package se.umu.cs.peer0019.pocketaid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import se.umu.cs.peer0019.pocketaid.models.AggregatedExpense
import se.umu.cs.peer0019.pocketaid.models.Expense
import java.text.NumberFormat
import kotlin.math.exp

/**
 * The Adapter creates ViewHolder objects as needed
 */
class ExpensesListAdapter(val expenses: List<AggregatedExpense>) : RecyclerView.Adapter<ExpensesListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_expense, parent, false)
        return ViewHolder(v)
    }

    /**
     * Populates data into the individual card view.
     */
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.placeItemView.text = expenses[i].place
        viewHolder.dateItemView.text = expenses[i].date
        viewHolder.categoryNameItemView.text = expenses[i].categoryName
        val amount = NumberFormat
            .getInstance()
            .format(expenses[i].amount)
            .toString()
        viewHolder.amountItemView.text = "$amount kr"
        viewHolder.descriptionItemView.text = expenses[i].description
        viewHolder.symbolItemView.text = expenses[i].categoryName.substring(0, 1)
    }

    override fun getItemCount(): Int {
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
        var descriptionItemView: TextView
        var symbolItemView: Button

        var data: AggregatedExpense? = null

        init {
            placeItemView = itemView.findViewById(R.id.expenses_list_item_place)
            dateItemView = itemView.findViewById(R.id.expenses_list_item_date)
            categoryNameItemView = itemView.findViewById(R.id.expenses_list_item_category_name)
            amountItemView = itemView.findViewById(R.id.expenses_list_item_amount)
            descriptionItemView = itemView.findViewById(R.id.expenses_list_item_description)
            symbolItemView = itemView.findViewById(R.id.expenses_list_item_symbol)
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
        private val EXPENSES_COMPARATOR = object : DiffUtil.ItemCallback<AggregatedExpense>() {
            override fun areItemsTheSame(oldItem: AggregatedExpense, newItem: AggregatedExpense): Boolean {
                return oldItem === newItem
            }

            // todo: ?
            override fun areContentsTheSame(oldItem: AggregatedExpense, newItem: AggregatedExpense): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
