package com.example.saryuna
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<android.widget.Button>(R.id.btnOpenCalculator)?.setOnClickListener {
            val intent = Intent(this, activity_calculator::class.java)
            startActivity(intent)
        }
        findViewById<android.widget.Button>(R.id.btnOpenPlayer)?.setOnClickListener {
            val intent = Intent(this, activity_player::class.java)
            startActivity(intent)
        }

    }

}