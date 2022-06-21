/*
package se.umu.cs.peer0019.pocketaid.db;

import androidx.annotation.WorkerThread
import se.umu.cs.peer0019.pocketaid.models.Expense
import se.umu.cs.peer0019.pocketaid.db.TodoDao
import kotlinx.coroutines.flow.Flow

*/
/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 *//*

class TodoRepository(private val todoDao: TodoDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allTodos: Flow<List<Todo>> = todoDao.getTodos()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }

    suspend fun delete(todo: Todo) {
        todoDao.delete(todo)
    }
}
*/
