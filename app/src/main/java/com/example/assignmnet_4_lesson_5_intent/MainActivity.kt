package com.example.assignmnet_4_lesson_5_intent

import User
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.assignmnet_4_lesson_5_intent.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var users: ArrayList<User> = arrayListOf(
        User("first1","last1","user1", "password1"),
        User("first2","last2","user2", "password2"),
        User("first3","last3","user3", "password3"),
        User("first4","last4","user4", "password4"),
        User("first5","last5","user5", "password5")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstname = intent.getStringExtra("firstname")
        val lastname = intent.getStringExtra("lastname")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        if (firstname != null && lastname != null && email != null && password != null) {
            Toast.makeText(this, "Account created", Toast.LENGTH_LONG).show()
            val user = User(firstname,lastname,email,password)
            users.add(user)
        }

        binding.signInButton.setOnClickListener {
            users.forEach { user ->
                if (user.username == binding.emailEditText.text.toString() && user.password == binding.passwordEditText.text.toString()) {
                    val intent = Intent(this, ShoppingCategoryActivity::class.java)
                    intent.putExtra("username", user.username)
                    startActivity(intent)
                }
            }
        }

        binding.createAccountBtn.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }

        binding.forgotPassword.setOnClickListener {
            users.forEach { user ->
                val emailSelectorIntent = Intent(Intent.ACTION_SENDTO)
                emailSelectorIntent.data = Uri.parse("mailto:" + user.username)

                val emailIntent = Intent(Intent.ACTION_SEND)
                emailIntent.selector = emailSelectorIntent

                startActivity(emailIntent)
            }

        }
    }
}