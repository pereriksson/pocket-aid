package se.umu.cs.peer0019.pocketaid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.aachartmodel.aainfographics.aachartcreator.*
import com.github.aachartmodel.aainfographics.aaoptionsmodel.*

class ReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(CanadaChart(this))
        // TODO: Använd en stacked bar chart för vyn
        // https://github.com/AAChartModel/AAChartCore-Kotlin
        // TODO: Sätt legend color till vit, dölj datalabels för att få en större pie chart

        val aaChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Pie)
            .title("Utgifter mars 2022")
            .titleStyle(
                AAStyle()
                    .color("#ffffff")
                    .fontSize(20)
            )
            .backgroundColor("#4b2b7f")
            .dataLabelsEnabled(true)
            .series(arrayOf(
                AASeriesElement()
                    .data(arrayOf(
                        arrayOf("Bio", 10),
                        arrayOf("Elektronik", 20),
                        arrayOf("Mat", 80)
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

        setContentView(R.layout.activity_report)
        val aaChartView = findViewById<AAChartView>(R.id.aa_chart_view)
        //aaChartView.aa_drawChartWithChartModel(aaChartModel)
        aaChartView.aa_drawChartWithChartOptions(aaChartOptions)
    }
}