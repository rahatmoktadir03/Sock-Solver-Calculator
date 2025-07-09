package com.example.animalsockcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animalsockcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding  // ViewBinding reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            calculateSocks()
        }
    }

    private fun calculateSocks() {
        // Read input safely (null-checking and fallback to 0)
        val insects = binding.editTextInsects.text.toString().toIntOrNull() ?: 0
        val bigCats = binding.editTextBigCats.text.toString().toIntOrNull() ?: 0
        val birds = binding.editTextBirds.text.toString().toIntOrNull() ?: 0

        // Each animal type has specific legs
        val insectLegs = insects * 6
        val bigCatLegs = bigCats * 4
        val birdLegs = birds * 2

        val totalLegs = insectLegs + bigCatLegs + birdLegs
        val totalSocks = totalLegs  // One sock per leg

        // Optional: Add price per sock
        val pricePerSock = 0.50
        val totalCost = totalSocks * pricePerSock

        // Format and show result
        val result = """
            Total Legs: $totalLegs
            Socks Needed: $totalSocks
            Total Sock Cost: $${"%.2f".format(totalCost)}
        """.trimIndent()

        binding.textViewResult.text = result
    }
}
