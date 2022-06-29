package se.umu.cs.peer0019.pocketaid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import se.umu.cs.peer0019.pocketaid.viewmodels.ExpensesViewModel

class MainActivity : AppCompatActivity() {
    lateinit var model: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up navigation
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)

        // tood: observable + room + modelview
        // todo: snyggare lite mörkare tema i appen
        // todo: Testa bakåt-knappen ordentligt
        // todo: Testa recover state ordentligt (se inlupp 1)
        // todo: ta bort alla copyright google kommentarsblock längst up i alla filer
        // TODO: Se till så att rensad app + skapa demodata visar upp data direkt i alla vyer
        // TODO: Kolla igenom Logcat innan inlämningen
        // todo Kolla i forumet vilken appen ska vara kompatibel med
        // todo Testa på många API-versioner/enheter
        // todo: använd ej bundle writeBoolean
        // todo: metoder ska vara relativt små
        // todo: dark theme (google krav)
        // todo: ska jag hämta data i fragment eller i activity?
        // TODO: Testa att stänga appen i varje vy+fragment
        // todo ViewModel + livedata
        // todo: läs på om context
        // todo: vad är destinations?
        // todo: vad är companion object?
        // todo: gå igenom allt under todo-fliken i IDE:n
        // todo: dokumentation av klasser, metoder
        // todo: se till att metoder inte är för långa
        // todo: add expense borde kräve att formuläret är ifyllt
        // todo: kunna klicka på en expense i listan (skicka argument till fragment)
        // https://www.youtube.com/watch?v=fEmS9vEUqTE
    }
}