package com.example.assignmnet_4_lesson_5_intent

import User
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.assignmnet_4_lesson_5_intent.databinding.ActivityCreateAccountBinding
import com.example.assignmnet_4_lesson_5_intent.databinding.ActivityMainBinding

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)

        findViewById<Button>(R.id.createAccount).setOnClickListener {
            if (findViewById<EditText>(R.id.firstname).text.isNotEmpty()
                && findViewById<EditText>(R.id.lastname).text.isNotEmpty()
                && findViewById<EditText>(R.id.email).text.isNotEmpty()
                && findViewById<EditText>(R.id.password).text.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("firstname", findViewById<EditText>(R.id.firstname).text.toString())
                intent.putExtra("lastname", findViewById<EditText>(R.id.lastname).text.toString())
                intent.putExtra("email", findViewById<EditText>(R.id.email).text.toString())
                intent.putExtra("password", findViewById<EditText>(R.id.password).text.toString())
                startActivity(intent)
            }
        }
    }
}