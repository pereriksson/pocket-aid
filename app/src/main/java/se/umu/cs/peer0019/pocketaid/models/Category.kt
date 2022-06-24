package se.umu.cs.peer0019.pocketaid.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String
)