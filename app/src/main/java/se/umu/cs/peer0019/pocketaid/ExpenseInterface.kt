package se.umu.cs.peer0019.pocketaid

import se.umu.cs.peer0019.pocketaid.models.Expense

interface ExpenseInterface {
    fun onItemClick(expense: Expense);
}