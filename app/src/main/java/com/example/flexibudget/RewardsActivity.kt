package com.example.flexibudget

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RewardsActivity : AppCompatActivity() {

    private lateinit var tvRewards: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewards)

        tvRewards = findViewById(R.id.tvRewards)

        CoroutineScope(Dispatchers.IO).launch {
            val expenseDao = AppDatabase.getInstance(this@RewardsActivity).expenseDao()
            val expenses = expenseDao.getAllExpenses()
            val totalSpent = expenses.sumOf { it.amount }

            val rewardMessage = when {
                totalSpent < 100 -> "Keep going! Small rewards await."
                totalSpent < 500 -> "Nice work! You’ve unlocked a Bronze reward."
                totalSpent < 1000 -> "Great job! You’ve unlocked a Silver reward."
                else -> "Amazing! You’ve unlocked a Gold reward 🎉"
            }

            runOnUiThread {
                tvRewards.text = rewardMessage
            }
        }
    }
}
