package se.umu.cs.peer0019.pocketaid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import se.umu.cs.peer0019.pocketaid.db.Db

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.expensesFragment,
                R.id.reportsFragment,
                R.id.settingsFragment
            )
        )
        navView.setupWithNavController(navController)



        val db = Db(this)
        println("i databasen: ${db.getExpenses().size} expenses, ${db.getCategories().size} categories")

        // todo: Expense ska kanske vara en data-klass
        // todo: ta bort alla copyright google kommentarsblock längst up i alla filer

        // todo: använd en ConstraintLayout
        // TODO: Kolla igenom Logcat innan inlämningen
        // TODO: Feature to generate demo data
        // todo: skapa upp en category/expense klass
        // TODO: Se till att du testar gamla API:versioner >= 21
        // Kolla i forumet vilken appen ska vara kompatibel med
        // Testa på många API-versioner/enheter
        // todo: använd ej bundle writeBoolean
        // todo: metoder ska vara relativt små

        // Get categories from backend
//        val db = Db(this)
//        db.addCategory("Mat")
//        db.addCategory("Elektronik")
//        db.addCategory("Resa")
//        db.addCategory("Bio")
//        db.addExpense("Espresso House", "Fika med Anna", 1, "2022-01-01", 74)
//        db.addExpense("Espresso House", "Fika med Peter", 1, "2022-01-02", 55)
//        db.addExpense("Espresso House", "Fika med Frida", 1, "2022-01-03", 149)
//        db.addExpense("Espresso House", "Fika med Erik", 1, "2022-01-04", 65)
//        db.addExpense("Media Markt", "PHILIPS 55\" LED 4K UHD Smart TV", 2, "2022-01-04", 4490)
//        val categories = db.getCategories()
//        println(categories.size)
//        val expenses = db.getExpenses()
//        println(expenses.size)
    }
}