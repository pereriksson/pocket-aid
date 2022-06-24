package se.umu.cs.peer0019.pocketaid.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "place")
    val place: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "categoryId")
    val categoryId: Int,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "amount")
    val amount: Int
)