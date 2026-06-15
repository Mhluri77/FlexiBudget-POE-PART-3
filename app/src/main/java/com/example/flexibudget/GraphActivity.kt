package com.example.flexibudget

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GraphActivity : AppCompatActivity() {

    private lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        barChart = findViewById(R.id.barChart)

        // Load expenses from Room
        CoroutineScope(Dispatchers.IO).launch {
            val expenseDao = AppDatabase.getInstance(this@GraphActivity).expenseDao()
            val expenses = expenseDao.getAllExpenses()

            val entries = expenses.mapIndexed { index, expense ->
                BarEntry(index.toFloat(), expense.amount.toFloat())
            }

            val dataSet = BarDataSet(entries, "Expenses")
            val barData = BarData(dataSet)

            runOnUiThread {
                barChart.data = barData
                barChart.invalidate() // refresh chart
            }
        }
    }
}
