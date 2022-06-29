package se.umu.cs.peer0019.pocketaid.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import se.umu.cs.peer0019.pocketaid.models.Category
import se.umu.cs.peer0019.pocketaid.models.Expense

@Database(
    entities = [Expense::class, Category::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase () {
    abstract fun expenseDao(): ExpenseDao

}