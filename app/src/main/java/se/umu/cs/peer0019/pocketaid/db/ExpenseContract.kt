package se.umu.cs.peer0019.pocketaid.db

import android.provider.BaseColumns

object ExpenseContract {
    object ExpenseEntry : BaseColumns {
        const val TABLE_NAME = "expenses"
        const val COLUMN_NAME_PLACE = "place"
        const val COLUMN_NAME_DESCRIPTION = "description"
        const val COLUMN_NAME_CATEGORY_ID = "categoryId"
        const val COLUMN_NAME_DATE = "date"
        const val COLUMN_NAME_AMOUNT = "amount"
    }
}

