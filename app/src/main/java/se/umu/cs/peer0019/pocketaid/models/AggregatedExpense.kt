package se.umu.cs.peer0019.pocketaid.models

/**
 * This model also contains the category name to easily
 * be used in the RecyclerView.
 */
data class AggregatedExpense(
    val id: Int,
    val place: String,
    val description: String,
    val categoryId: Int,
    val categoryName: String,
    val date: String,
    val amount: Int
)