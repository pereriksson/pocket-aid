package se.umu.cs.peer0019.pocketaid.db

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import se.umu.cs.peer0019.pocketaid.model.Category
import se.umu.cs.peer0019.pocketaid.model.Expense

class Db (
    private val context: Context
    ) {
    fun getExpenses(): List<Expense> {
        val dbHelper = ExpensesDbHelper(context)
        val db = dbHelper.readableDatabase
        val projection = arrayOf(
            BaseColumns._ID,
            ExpenseContract.ExpenseEntry.COLUMN_NAME_PLACE,
            ExpenseContract.ExpenseEntry.COLUMN_NAME_DESCRIPTION,
            ExpenseContract.ExpenseEntry.COLUMN_NAME_CATEGORY_ID,
            ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE,
            ExpenseContract.ExpenseEntry.COLUMN_NAME_AMOUNT
        )

        val cursor = db.query(
            ExpenseContract.ExpenseEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val expenses = mutableListOf<Expense>()
        with(cursor) {
            while (moveToNext()) {
                // Column index 1 is "Name"
                expenses.add(
                    Expense(
                        getInt(0),
                        getString(1),
                        getString(2),
                        getInt(3),
                        getString(4),
                        getInt(5)
                    )
                )
            }
        }
        cursor.close()
        db.close()
        return expenses
    }

    fun getCategories(): List<Category> {
        val dbHelper = ExpensesDbHelper(context)
        val db = dbHelper.readableDatabase
        val projection = arrayOf(BaseColumns._ID, CategoryContract.CategoryEntry.COLUMN_NAME_NAME)
        val sortOrder = "${CategoryContract.CategoryEntry.COLUMN_NAME_NAME} DESC"

        val cursor = db.query(
            CategoryContract.CategoryEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            sortOrder
        )

        val categories = mutableListOf<Category>()
        with(cursor) {
            while (moveToNext()) {
                // Column index 1 is "Name"
                categories.add(
                    Category(
                        getInt(0),
                        getString(1)
                    )
                )
            }
        }
        cursor.close()
        db.close()
        return categories
    }

    // todo: Take a category object instead
    fun addCategory(name: String):Long? {
        val dbHelper = ExpensesDbHelper(context)
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(CategoryContract.CategoryEntry.COLUMN_NAME_NAME, name)
        }
        val categoryId = db?.insert(CategoryContract.CategoryEntry.TABLE_NAME, null, values)
        db.close()
        return categoryId
    }

    fun addExpense(place: String, description: String, categoryId: Int, date: String, amount: Int): Long? {
        val dbHelper = ExpensesDbHelper(context)
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(ExpenseContract.ExpenseEntry.COLUMN_NAME_PLACE, place)
            put(ExpenseContract.ExpenseEntry.COLUMN_NAME_DESCRIPTION, description)
            put(ExpenseContract.ExpenseEntry.COLUMN_NAME_CATEGORY_ID, categoryId)
            put(ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE, date)
            put(ExpenseContract.ExpenseEntry.COLUMN_NAME_AMOUNT, amount)
        }
        val expenseId = db?.insert(ExpenseContract.ExpenseEntry.TABLE_NAME, null, values)
        db.close()
        return expenseId
    }
}