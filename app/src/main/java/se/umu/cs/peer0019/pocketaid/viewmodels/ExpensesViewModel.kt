package se.umu.cs.peer0019.pocketaid.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.room.Room
import se.umu.cs.peer0019.pocketaid.db.AppDatabase
import se.umu.cs.peer0019.pocketaid.models.AggregatedExpense

class ExpensesViewModel(application: Application): AndroidViewModel(application) {
    private val expenses = mutableListOf<AggregatedExpense>()
    private val context = getApplication<Application>().applicationContext

    fun getExpenses() {
        val db = Room.databaseBuilder(
            context,
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
    }
}