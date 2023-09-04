package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Declaring the input and the results

        val result = findViewById<TextView>(R.id.result)
        val calculation = findViewById<TextView>(R.id.calculation)
        var res = ""
        var calc =""


        // declaring a function that make the calculation display = the res display


        fun resultDisplay(){
            result.text = res
        }


        fun calculationDisplay(){
            calculation.text = calc
        }



        // Declaring all the operators
        val clearBtn  = findViewById<Button>(R.id.clearBtn)
        val deleteBtn = findViewById<Button>(R.id.deleteBtn)
        val percentBtn = findViewById<Button>(R.id.percentBtn)
        val addBtn = findViewById<Button>(R.id.addBtn)
        val subBtn = findViewById<Button>(R.id.subBtn)
        val multiplyBtn = findViewById<Button>(R.id.multiplyBtn)
        val equalsBtn = findViewById<Button>(R.id.equalsBtn)
        val dotBtn = findViewById<Button>(R.id.dotBtn)
        val divideBtn = findViewById<Button>(R.id.divideBtn)




        //// Declaring all the numbers buttons

        val btnZero = findViewById<Button>(R.id.btnZero)
        val btnOne  = findViewById<Button>(R.id.btnOne)
        val btnTwo = findViewById<Button>(R.id.btnTwo)
        val btnThree = findViewById<Button>(R.id.btnThree)
        val btnFour = findViewById<Button>(R.id.btnFour)
        val btnFive = findViewById<Button>(R.id.btnFive)
        val btnSix = findViewById<Button>(R.id.btnSix)
        val btnSeven = findViewById<Button>(R.id.btnSeven)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)



        /// setting onclickListener on all of the numbers buttons to the display text
        btnZero.setOnClickListener(View.OnClickListener {
            if (calc.isEmpty()) {
                calc += "0"
            }
             else if (calc.isNotEmpty() && calc.last() in setOf('+','-','*','/')) {
                calc += "0"
            }
            else if (calc.isNotEmpty() && calc != "0"){
                calc +="0"
            }
            calculationDisplay()
        })

        btnOne.setOnClickListener(View.OnClickListener {
            calc +="1"
            calculationDisplay()
        })

        btnTwo.setOnClickListener(View.OnClickListener {
            calc +="2"
            calculationDisplay()
        })

        btnThree.setOnClickListener(View.OnClickListener {
            calc +="3"
            calculationDisplay()
        })

        btnFour.setOnClickListener(View.OnClickListener {
            calc +="4"
            calculationDisplay()
        })

        btnFive.setOnClickListener(View.OnClickListener {
            calc +="5"
            calculationDisplay()
        })

        btnSix.setOnClickListener(View.OnClickListener {
            calc +="6"
            calculationDisplay()
        })

        btnSeven.setOnClickListener(View.OnClickListener {
            calc +="7"
            calculationDisplay()
        })

        btnEight.setOnClickListener(View.OnClickListener {
            calc +="8"
            calculationDisplay()
        })

        btnNine.setOnClickListener(View.OnClickListener {
            calc +="9"
            calculationDisplay()
        })

        // operators
        addBtn.setOnClickListener(View.OnClickListener {

            if(calc.isEmpty() && !calc.endsWith("+")){
                calc +="+"
                calculationDisplay()
            }
            else if (calc.isNotEmpty() && !calc.endsWith("+")){
                calc +="+"
                calculationDisplay()
            }
        })
        multiplyBtn.setOnClickListener(View.OnClickListener {
            if (calc.isNotEmpty() && !calc.endsWith("*")){
                calc +="*"
                calculationDisplay()
            }
        })

        subBtn.setOnClickListener(View.OnClickListener {
            if(calc.isEmpty() && !calc.endsWith("-")){
                calc +="-"
                calculationDisplay()
            }
            else if (calc.isNotEmpty() && !calc.endsWith("-")){
                calc +="-"
                calculationDisplay()
            }
        })
        divideBtn.setOnClickListener(View.OnClickListener {
            if (calc.isNotEmpty() && !calc.endsWith("/")){
                calc +="/"
                calculationDisplay()
            }
        })


        percentBtn.setOnClickListener(View.OnClickListener {
            if (calc.isNotEmpty()){
                val percentageValue = calc.toDouble()/100
                res = percentageValue.toString()
                calculationDisplay()
                resultDisplay()

            }
        })



        // I created a clear function that will be called on the clearButton onClickedListener

        fun clearButton(){
            calc = ""
            res = ""
        }
        clearBtn.setOnClickListener(View.OnClickListener {
            clearButton()
            calculationDisplay()
            resultDisplay()
        })


        // creating functionality for the backspace button
        deleteBtn.setOnClickListener(View.OnClickListener {
            if(calc.isNotEmpty()){
                calc = calc.substring(0,calc.length-1)
            }
            calculationDisplay()
        })

        // creating the dot button we need a boolean to check if its empty or with a value
        var dotInserted = false
        var operatorInserted = false
        dotBtn.setOnClickListener(View.OnClickListener {
            // To check if the calc is empty then append "0."
            if (calc.isEmpty()) {
                calc += "0."
                dotInserted = true
            }

            else if(calc.isNotEmpty()&& calc.last() !in setOf('.','+','-','*','/')){
               calc+="."
            }
//
//
            calculationDisplay()
        })

        equalsBtn.setOnClickListener{
            try{
            val expression = ExpressionBuilder(calc).build()
            val resultString = expression.evaluate()

                    res = "=${resultString.toString()}"
                    resultDisplay()

        }
            catch(e: java.lang.ArithmeticException){
                res = "Cannot Divide By Zero"
                resultDisplay()
            }
            catch (e: java.lang.Exception){
                res = "Invalid Expression"
                resultDisplay()
            }
        }

    }
}