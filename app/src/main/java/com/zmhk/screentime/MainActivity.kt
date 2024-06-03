package com.zmhk.screentime

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnMainMenu: Button = findViewById(R.id.btnMenu)
        btnMainMenu.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }

        val btnExit: Button = findViewById(R.id.btnExit)
        btnExit.setOnClickListener {

            exitProcess(0)
          //  val intent = Intent(this, MainActivity::class.java)
           // startActivity(intent)
        }
    }
}