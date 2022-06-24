package se.umu.cs.peer0019.pocketaid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.github.aachartmodel.aainfographics.aachartcreator.*
import com.github.aachartmodel.aainfographics.aaoptionsmodel.*
import se.umu.cs.peer0019.pocketaid.R
import se.umu.cs.peer0019.pocketaid.db.AppDatabase
import se.umu.cs.peer0019.pocketaid.models.Category

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReportsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReportsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reports, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // TODO: DO NOT fetch on main thread!
        this.context?.let { context ->
            val db = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "expenses"
            ).allowMainThreadQueries().build()

            val ed = db.expenseDao()
            val categories = ed.getCategories()

            var statistics = Array<Any>(categories.size){}

            categories.forEachIndexed { index, category ->
                val expenses = ed.getExpenses().filter {
                    it.categoryId == category.id
                }
                val total = expenses.fold(0) { sum, expense -> sum + expense.amount }
                statistics[index] = arrayOf(category.name, total)
            }

            val plotOptions = AAPlotOptions()
                .series(
                    AASeries()
                        .borderColor("transparent")
                )
            // Gör till en view?
            val aaChartModel : AAChartModel = AAChartModel()
                .chartType(AAChartType.Pie)
                .backgroundColor("transparent")
                .dataLabelsEnabled(true)
                .colorsTheme(
                    arrayOf(
                        // TODO: Create strings for these
                        // TODO: Make sure we have enough colors as categories are defined by the user
                        "#7EFEBF",
                        "#0ACAF3",
                        "#FF107C",
                        "#FFBF68",
                        "#ED71FE"
                    )
                )
                .series(arrayOf(
                    AASeriesElement()
                        .data(statistics)
                        .dataLabels(
                            AADataLabels()
                                .enabled(false)
                        )
                        .name("Utgifter")
                ))

            val aaChartOptions = aaChartModel
                .aa_toAAOptions()
                .legend(
                    AALegend()
                        .itemStyle(
                            AAItemStyle()
                                .color("#ffffff")
                                .fontSize(18.toFloat())
                                .fontWeight("400")
                        )
                        .itemMarginTop(16.toFloat())
                )
            //.plotOptions(plotOptions)   //legenden försvinner
            val aaChartView = view.findViewById<AAChartView>(R.id.aa_chart_view)
            aaChartView.aa_drawChartWithChartOptions(aaChartOptions)
        }


        // Todo: view.context är alltid ett objekt i denna metod, använda denna istf onCreateView?
        // TODO: Lägg lite tid på att hitta ett snyggt färgschema
        // TODO: Knapp på första sidan "Lägg in utgift"
        // TODO: Inställningar (lägga till kategorier, beloppspärr etc)
        // TODO: Gör en YouTube-video
        // TODO: Det ska gå att göra pie charten till en cirkel!
        // TODO: Gör en egen snygg klass av detta
        // TODO: activities:
        // TODO: HomeActivity
        // TODO: AddExpenseActivity
        // TODO: SettingsActivity
        // TODO: ReportActivity

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReportsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReportsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}