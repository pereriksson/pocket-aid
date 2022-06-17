package se.umu.cs.peer0019.pocketaid.db

import android.provider.BaseColumns

object CategoryContract {
    object CategoryEntry : BaseColumns {
        const val TABLE_NAME = "categories"
        const val COLUMN_NAME_NAME = "name"
    }
}

