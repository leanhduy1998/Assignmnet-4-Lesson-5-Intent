package com.example.assignmnet_4_lesson_5_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.assignmnet_4_lesson_5_intent.databinding.ActivityMainBinding
import com.example.assignmnet_4_lesson_5_intent.databinding.ActivityShoppingCategoryBinding

class ShoppingCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        findViewById<ImageButton>(R.id.beauty).setOnClickListener {
            Toast.makeText(this@ShoppingCategoryActivity, "You have chosen the Beauty category of shopping", Toast.LENGTH_LONG).show()
        }

        findViewById<ImageButton>(R.id.eletronic).setOnClickListener {
            Toast.makeText(this@ShoppingCategoryActivity, "You have chosen the Electronic category of shopping", Toast.LENGTH_LONG).show()
        }

        findViewById<ImageButton>(R.id.clothes).setOnClickListener {
            Toast.makeText(this@ShoppingCategoryActivity, "You have chosen the Clothes category of shopping", Toast.LENGTH_LONG).show()
        }

        findViewById<ImageButton>(R.id.food).setOnClickListener {
            Toast.makeText(this@ShoppingCategoryActivity, "You have chosen the Food category of shopping", Toast.LENGTH_LONG).show()
        }

        val username = intent.getStringExtra("username")
        findViewById<TextView>(R.id.welcomeText).text = "Welcome " + username
    }
}