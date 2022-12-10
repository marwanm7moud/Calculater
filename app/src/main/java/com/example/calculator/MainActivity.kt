package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

   private var text: TextView? = null
    private var lastNumeric: Boolean = true
    private var lastDot: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.Text)


    }

    fun CLR(view: View) {
        text?.text = ""
    }

    fun onDigit(view: View) {
        text?.append((view as Button).text)
        lastNumeric = true


    }


    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            text?.append(".")
            lastDot = true
            lastNumeric = false
        }

    }

    fun onOperation(view: View) {

        if (!isOperationAdded(text?.text.toString()) && lastNumeric) {
            text?.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }

    }

    private fun isOperationAdded(value: String): Boolean {
        return if (value.contains("-")) {
            false
        } else {
            value.contains("/") || value.contains("-") || value.contains("+") || value.contains("*")
        }
    }

    fun onEqual(view: View) {
        var tvValue = text?.text.toString()
        var prefix = ""
        if (lastNumeric) {
           if(tvValue.startsWith("-")){
               prefix = "-"
               tvValue = tvValue.substring(1)
           }
            if(tvValue.startsWith("+")){
                tvValue = tvValue.substring(1)
            }



            if(tvValue.contains("-")){
                val splitedText = tvValue.split("-")
                var one = splitedText[0]
                var two = splitedText[1]
                if(prefix.isNotEmpty()){
                    one = prefix+one
                    text?.setText("${one.toDouble() - two.toDouble()}")
                }else {
                    text?.setText("${one.toDouble() - two.toDouble()}")
                }
            }
            else if(tvValue.contains("*")){
                val splitedText = tvValue.split("*")
                var one = splitedText[0]
                var two = splitedText[1]
                if(prefix.isNotEmpty()){
                    one = prefix+one
                    text?.setText("${one.toDouble() * two.toDouble()}")
                }else {
                    text?.setText("${one.toDouble() * two.toDouble()}")
                }
            }
            else if(tvValue.contains("+")){
                val splitedText = tvValue.split("+")
                var one = splitedText[0]
                var two = splitedText[1]
                if(prefix.isNotEmpty()){
                    one = prefix+one
                    text?.setText("${one.toDouble() + two.toDouble()}")
                }else {
                    text?.setText("${one.toDouble() + two.toDouble()}")
                }
            }
            else if(tvValue.contains("/")){
                val splitedText = tvValue.split("/")
                var one = splitedText[0]
                var two = splitedText[1]
                if(prefix.isNotEmpty()){
                    one = prefix+one
                    text?.setText("${one.toDouble() / two.toDouble()}")
                }else {
                    text?.setText("${one.toDouble() / two.toDouble()}")
                }
            }

        }



    }


}