package se.umu.cs.peer0019.pocketaid
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import se.umu.cs.peer0019.pocketaid.ui.theme.PocketAidTheme
//
//class PocketAidActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PocketAidApp()
//        }
//
//        // todo: https://developer.android.com/jetpack/compose/interop/interop-apis#views-in-compose
//
//    }
//}
//
//@Composable
//fun PocketAidApp() {
//    PocketAidTheme {
//        val allScreens = RallyScreen.values().toList()
//        val navController = rememberNavController()
//        val backstackEntry = navController.currentBackStackEntryAsState()
//        val currentScreen = RallyScreen.fromRoute(backstackEntry.value?.destination?.route)
//
//        Scaffold(
//            topBar = {
//                RallyTabRow(
//                    allScreens = allScreens,
//                    onTabSelected = { screen ->
//                        navController.navigate(screen.name)
//                    },
//                    currentScreen = currentScreen
//                )
//            }
//        ) { innerPadding ->
//            RallyNavHost(navController, modifier = Modifier.padding(innerPadding))
//        }
//    }
//    }
//}
//
////@Composable
////fun CustomView() {
////    val selectedItem = remember { mutableStateOf(0) }
////
////    // Adds view to Compose
////    AndroidView(
////        modifier = Modifier.fillMaxSize(), // Occupy the max size in the Compose UI tree
////        factory = { context ->
////            // Creates custom view
////            CustomView(context).apply {
////                // Sets up listeners for View -> Compose communication
////                myView.setOnClickListener {
////                    selectedItem.value = 1
////                }
////            }
////        },
////        update = { view ->
////            // View's been inflated or state read in this block has been updated
////            // Add logic here if necessary
////
////            // As selectedItem is read here, AndroidView will recompose
////            // whenever the state changes
////            // Example of Compose -> View communication
////            view.coordinator.selectedItem = selectedItem.value
////        }
////    )
////}
//
//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Composable
//fun ExpenseGroup(name: String) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {
//        Text(
//            text = name,
//            modifier = Modifier
//                .background(Color(0xf0f0f4ff))
//                .fillMaxWidth()
//                .padding(
//                    start = 10.dp,
//                    top = 3.dp,
//                    bottom = 3.dp
//                ),
//            fontSize = 17.sp
//        )
//    }
//}
//
//@Composable
//fun Expense(place: String, description: String, categoryId: Int, date: String, amount: Int) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {
//        Column(
//            modifier = Modifier
//                .width(90.dp)
//                .padding(
//                    start = 10.dp,
//                    top = 10.dp
//                )
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(70.dp)
//                    .clip(CircleShape)
//                    .background(Color(0x40ba50ff))
//            ) {
//                Text("1")
//            }
//
//        }
//        Column(
//            modifier = Modifier
//                .weight(1f)
//                .padding(
//                    top = 10.dp
//                )
//        ) {
//            Text(place)
//            Text(date)
//            Text("Category name")
//        }
//        Column(
//            modifier = Modifier
//                .width(60.dp)
//                .padding(
//                    top = 30.dp,
//                    end = 10.dp
//                )
//        ) {
//            Text(text = "100 kr")
//        }
//    }
///*
//    <LinearLayout
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:orientation="horizontal">
//        <!-- first column -->
//        <LinearLayout
//            android:layout_width="70dp"
//            android:layout_height="wrap_content"
//            android:paddingStart="10dp"
//            android:paddingEnd="10dp"
//            android:paddingTop="3dp"
//            android:orientation="vertical">
//            <!-- category icon -->
//            <Button
//                android:layout_width="45dp"
//                android:layout_height="45dp"
//                android:background="@drawable/rectangle"
//                android:layout_marginTop="8dp"
//                android:text="A" />
//        </LinearLayout>
//        <!-- second column -->
//        <LinearLayout
//            android:layout_width="0dp"
//            android:layout_height="wrap_content"
//            android:orientation="vertical"
//            android:paddingTop="4dp"
//            android:layout_weight="1">
//            <TextView
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:text="PLACE"/>
//            <TextView
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:text="DATE"/>
//            <TextView
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:text="CATEGORY_NAME"/>
//        </LinearLayout>
//        <!-- third column -->
//        <LinearLayout
//            android:layout_width="wrap_content"
//            android:layout_height="wrap_content"
//            android:paddingTop="20dp"
//            android:paddingEnd="10dp">
//            <TextView
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:text="AMOUNT"/>
//        </LinearLayout>
//    </LinearLayout>
//
//     */
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    PocketAidTheme {
//        Greeting("Android")
//    }
//}