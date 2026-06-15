package com.example.flexibudget

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flexibudget.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigate to Add Expense screen
        binding.btnAddExpense.setOnClickListener {
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }

        // Navigate to Graphs screen
        binding.btnViewGraph.setOnClickListener {
            startActivity(Intent(this, GraphActivity::class.java))
        }

        // Navigate to Rewards screen
        binding.btnRewards.setOnClickListener {
            startActivity(Intent(this, RewardsActivity::class.java))
        }
    }
}
