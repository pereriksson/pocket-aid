package se.umu.cs.peer0019.pocketaid.models

// todo: make a data class?

class Expense(
    id: Int,
    place: String,
    description: String,
    categoryId: Int,
    date: String,
    amount: Int
) {
    val id: Int = id
    val place: String = place
    val description: String = description
    val categoryId: Int = categoryId
    val date: String = date
    val amount: Int = amount
}