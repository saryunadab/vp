package com.example.saryuna
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var buffer: Double? = null
    private var op: String? = null
    private var isNewInput = true
    private lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)
    }


    fun appendText(view: View) {
        if (isNewInput) {
            display.text = ""
            isNewInput = false
        }
        val button = view as Button
        display.append(button.text)
    }


    fun ops(view: View) {
        buffer = display.text.toString().toDouble()
        val button = view as Button
        op = button.text.toString()
        isNewInput = true
        display.text = op
    }


    fun equal(view: View) {
        try {
            val secondValue = display.text.toString().toDouble()
            val currentBuffer = buffer

            if (currentBuffer != null && op != null) {
                val result = when (op) {
                    "+" -> currentBuffer + secondValue
                    "-" -> currentBuffer - secondValue
                    "*" -> currentBuffer * secondValue
                    "/" -> {
                        if (secondValue == 0.0) {
                            display.text = "Error"
                            isNewInput = true
                            buffer = null
                            op = null
                            return
                        } else {
                            currentBuffer / secondValue
                        }
                    }
                    else -> null
                }

                if (result != null) {
                    display.text = result.toString()
                    buffer = result
                } else {
                    display.text = "Error"
                }
            } else {
                buffer = secondValue
            }

            isNewInput = true
            op = null
        } catch (e: NumberFormatException) {
            display.text = "Error"
            isNewInput = true
            buffer = null
            op = null
        }
    }


    fun back(view: View) {
        val currentText = display.text.toString()
        if (currentText.isNotEmpty()) {
            display.text = currentText.dropLast(1)
        }
    }

    fun backAll(view: View) {
        buffer = null
        op = null
        display.text = ""
        isNewInput = true
    }


    fun floatInput(view: View) {
        if (isNewInput) {
            display.text = "0."
            isNewInput = false
        } else if (!display.text.contains(".")) {
            display.append(".")
        }
    }
}