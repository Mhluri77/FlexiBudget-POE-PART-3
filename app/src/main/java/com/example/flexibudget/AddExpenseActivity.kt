package com.example.flexibudget

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var etCategory: EditText
    private lateinit var etAmount: EditText
    private lateinit var btnSaveExpense: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        // Bind views
        etCategory = findViewById(R.id.etCategory)
        etAmount = findViewById(R.id.etAmount)
        btnSaveExpense = findViewById(R.id.btnSaveExpense)

        // Handle button click
        btnSaveExpense.setOnClickListener {
            val category = etCategory.text.toString().trim()
            val amountText = etAmount.text.toString().trim()

            if (category.isEmpty() || amountText.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = amountText.toDoubleOrNull()
            if (amount == null) {
                Toast.makeText(this, "Enter a valid amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Save expense to database or pass back to main activity
            Toast.makeText(this, "Expense saved: $category - $amount", Toast.LENGTH_LONG).show()

            // Optionally clear fields
            etCategory.text.clear()
            etAmount.text.clear()
        }
    }
}
