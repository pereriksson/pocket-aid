package se.umu.cs.peer0019.pocketaid.db

import androidx.room.Dao
import androidx.room.Query
import se.umu.cs.peer0019.pocketaid.models.Category
import se.umu.cs.peer0019.pocketaid.models.Expense

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses")
    fun getExpenses(): List<Expense>
    @Query("SELECT * FROM expenses ORDER BY id DESC")
    fun getExpensesByDateDesc(): List<Expense>
    @Query("SELECT * FROM categories")
    fun getCategories(): List<Category>
    @Query("INSERT INTO expenses (place, description, categoryId, date, amount) VALUES(:place, :description, :categoryId, :date, :amount)")
    fun insertExpense(place: String, description: String, categoryId: Int, date: String, amount: Int)
    @Query("INSERT INTO categories (name, color) VALUES(:name, :color)")
    fun insertCategory(name: String, color: String)
    @Query("DELETE FROM categories")
    fun deleteCategories()
    @Query("DELETE FROM expenses")
    fun deleteExpenses()
}