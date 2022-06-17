package se.umu.cs.peer0019.pocketaid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.aachartmodel.aainfographics.aachartcreator.*
import com.github.aachartmodel.aainfographics.aaoptionsmodel.*

class ReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        val plotOptions = AAPlotOptions()
            .series(AASeries()
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
                    .data(arrayOf(
                        arrayOf("Bio", 10),
                        arrayOf("Elektronik", 20),
                        arrayOf("Mat", 80),
                        arrayOf("Film", 30),
                        arrayOf("Resa", 40)
                    ))
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

        setContentView(R.layout.activity_report)
        val aaChartView = findViewById<AAChartView>(R.id.aa_chart_view)
        aaChartView.aa_drawChartWithChartOptions(aaChartOptions)
    }
}