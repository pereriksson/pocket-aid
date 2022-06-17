package se.umu.cs.peer0019.pocketaid.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

private const val SQL_CREATE_CATEGORIES =
    "CREATE TABLE ${CategoryContract.CategoryEntry.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${CategoryContract.CategoryEntry.COLUMN_NAME_NAME} TEXT)"

private const val SQL_CREATE_EXPENSES =
    "CREATE TABLE ${ExpenseContract.ExpenseEntry.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${ExpenseContract.ExpenseEntry.COLUMN_NAME_PLACE} TEXT,"+
            "${ExpenseContract.ExpenseEntry.COLUMN_NAME_DESCRIPTION} TEXT,"+
            "${ExpenseContract.ExpenseEntry.COLUMN_NAME_DATE} TEXT,"+
            "${ExpenseContract.ExpenseEntry.COLUMN_NAME_CATEGORY_ID} INTEGER,"+
            "${ExpenseContract.ExpenseEntry.COLUMN_NAME_AMOUNT} INTEGER)"

private const val SQL_DELETE_CATEGORIES = "DROP TABLE IF EXISTS ${CategoryContract.CategoryEntry.TABLE_NAME}"
private const val SQL_DELETE_EXPENSES = "DROP TABLE IF EXISTS ${ExpenseContract.ExpenseEntry.TABLE_NAME}"

class ExpensesDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_CATEGORIES)
        db.execSQL(SQL_CREATE_EXPENSES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_CATEGORIES)
        db.execSQL(SQL_DELETE_EXPENSES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "expenses.db"
    }
}