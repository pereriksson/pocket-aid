package se.umu.cs.peer0019.pocketaid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import se.umu.cs.peer0019.pocketaid.db.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

//        val appBarConfig = AppBarConfiguration(
//            setOf(
//                R.id.expensesFragment,
//                R.id.reportsFragment,
//                R.id.settingsFragment
//            )
//        )
        navView.setupWithNavController(navController)

        // TODO: DO NOT fetch on main thread
        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "expenses"
        )
            .allowMainThreadQueries()
            .build()
        val ed = db.expenseDao()
        println("i databasen: ${ed.getExpenses().size} expenses, ${ed.getCategories().size} categories")

        // todo: Testa bakåt-knappen ordentligt!
        // todo: Testa recover state ordentligt (se inlupp 1)
        // todo: Expense ska kanske vara en data-klass
        // todo: ta bort alla copyright google kommentarsblock längst up i alla filer
        // TODO: Se till så att rensad app + skapa demodata visar upp data direkt i alla vyer
        // todo: använd en ConstraintLayout
        // TODO: Kolla igenom Logcat innan inlämningen
        // Kolla i forumet vilken appen ska vara kompatibel med
        // Testa på många API-versioner/enheter
        // todo: använd ej bundle writeBoolean
        // todo: metoder ska vara relativt små
        // todo: dark theme (google krav)
        // todo: ska jag hämta data i fragment eller i activity?
        // TODO: Testa att stänga appen i varje vy+fragment
        // todo ViewModel?
        // todo: läs på om context
        // todo: vad är destinations?
        // todo: vad är companion object?
    }

    val launcher=registerForActivityResult<Uri,Boolean>(
        //Vi använder det färdiga kontraktet för att ta bilder
        ActivityResultContracts.TakePicture()) {
        if(it) {
            //Bilden sparad till den plats vi angav i intentetIntent. Bilden kommer bytas ut
            //Då aktiviteten blir synlig
        }
    }

//    private fun takePicture() {
//
//        val uri: Uri
//
//        //Spara filen i vår local
//        // storage med en content-url. Det låter de oss spara filen var som helst utan att behöva
//        // bry os om att kameraappen har rättighet at skriva dit. Dessutom har vi
//        // om vi sparar filen på ett ställe vi har koll på kontroll över att ingen
//        // annan app sabbar något
//
//        val file = File(activity?.filesDir, "mypic.jpg")
//        // TODO: Flytta all logik till activity?
//        //uri = FileProvider.getUriForFile(activity?.applicationContext, "$activity.packageName.fileprovider", file!!)
//
//        //Starta aktiviteten
//
//        launcher.launch(uri)
//    }
}