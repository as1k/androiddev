package com.example.kotlinhw2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

enum class State {
    BEGIN, EQUAL, DOESNTMATTER
}

enum class Operation {
    PLUS, MINUS, DIVIDE, MULTIPLY, POW, PERCENT, SQRT, UNDEFINED
}

class MainActivity : AppCompatActivity() {
    private lateinit var tvInput: TextView
    private var valueOne = 0.0
    private var valueTwo = valueOne
    private var dotted = false
    private var state: State? = State.BEGIN
    private var operation: Operation? = Operation.UNDEFINED
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("temp", tvInput.text.toString())
        outState.putDouble("valueOne", valueOne)
        outState.putDouble("valueTwo", valueTwo)
        outState.putSerializable("state", state)
        outState.putSerializable("operation", operation)
        outState.putBoolean("dotted", dotted)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)
        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val btnPlus: Button = findViewById(R.id.btnPlus)
        val btnMinus: Button = findViewById(R.id.btnMinus)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivision: Button = findViewById(R.id.btnDivision)
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnPercent: Button = findViewById(R.id.btnPercent)
        val btnPow: Button = findViewById(R.id.btnPow)
        val btnRoot: Button = findViewById(R.id.btnRoot)
        val btnDot: Button = findViewById(R.id.btnDot)
        val btnEqual: Button = findViewById(R.id.btnEqual)
        if (savedInstanceState != null) {
            super.onRestoreInstanceState(savedInstanceState)
            valueOne = savedInstanceState.getDouble("valueOne")
            valueTwo = savedInstanceState.getDouble("valueTwo")
            dotted = savedInstanceState.getBoolean("dotted")
            operation = savedInstanceState.getSerializable("operation") as Operation?
            state = savedInstanceState.getSerializable("state") as State?
            tvInput.text = savedInstanceState.getString("temp")
        }
        val calculatorListener = View.OnClickListener { v ->
            when (v.id) {
                R.id.btn0 -> {
                    if (tvInput.text.toString() == "Infinity" || tvInput.text.toString() == "0" || tvInput.text.toString() == "Error!") {
                        tvInput.text = ""
                    }
                    if (state != State.BEGIN && state != State.EQUAL) {

                        state = State.BEGIN
                        tvInput.text = ""
                    }
                    if (tvInput.text.toString().isEmpty() && dotted) tvInput.text = "0" else tvInput.append("0")
                }
                R.id.btn1 -> {
                    if (tvInput.text.toString() == "0" || tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    if (state != State.BEGIN && state != State.EQUAL) {
                        state = State.BEGIN
                        tvInput.text = ""
                    }
                    tvInput.append("1")
                }
                R.id.btn2 -> {
                    if (tvInput.text.toString() == "0" || tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    if (state != State.BEGIN && state != State.EQUAL) {
                        state = State.BEGIN
                        tvInput.text = ""
                    }
                    tvInput.append("2")
                }
                R.id.btn3 -> {
                    if (tvInput.text.toString() == "0" || tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    if (state != State.BEGIN && state != State.EQUAL) {
                        state = State.BEGIN
                        tvInput.text = ""
                    }
                    tvInput.append("3")
                }
                R.id.btn4 -> {
                    if (tvInput.text.toString() == "0" || tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    if (state != State.BEGIN && state != State.EQUAL) {
                        state = State.BEGIN
                        tvInput.text = ""
                    }
                    tvInput.append("4")
                }
                R.id.btn5 -> {
                    if (tvInput.text.toString() == "0" || tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    if (state != State.BEGIN && state != State.EQUAL) {
                        state = State.BEGIN
                        tvInput.text = ""
                    }
                    tvInput.append("5")
                }
                R.id.btn6 -> {
                    if (tvInput.text.toString() == "0" || tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    if (state != State.BEGIN && state != State.EQUAL) {
                        state = State.BEGIN
                        tvInput.text = ""
                    }
                    tvInput.append("6")
                }
                R.id.btn7 -> {
                    if (tvInput.text.toString() == "0" || tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    if (state != State.BEGIN && state != State.EQUAL) {
                        state = State.BEGIN
                        tvInput.text = ""
                    }
                    tvInput.append("7")
                }
                R.id.btn8 -> {
                    if (tvInput.text.toString() == "0" || tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    if (state != State.BEGIN && state != State.EQUAL) {
                        state = State.BEGIN
                        tvInput.text = ""
                    }
                    tvInput.append("8")
                }
                R.id.btn9 -> {
                    if (tvInput.text.toString() == "0" || tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    if (state != State.BEGIN && state != State.EQUAL) {
                        state = State.BEGIN
                        tvInput.text = ""
                    }
                    tvInput.append("9")
                }
                R.id.btnDot -> {
                    if (tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    if (tvInput.text.toString().contains(".")) {
                        dotted = true
                    }
                    if (!dotted) tvInput.append(".")
                    dotted = true
                }
                R.id.btnPlus -> {
                    state = State.DOESNTMATTER
                    operation = Operation.PLUS
                    if (tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    try {
                        valueOne = tvInput.text.toString().toDouble()
                    } catch (e: NumberFormatException) {
                        tvInput.text = "Error!"
                    }
                    if (tvInput.text.toString() == "Error!") {
                        tvInput.text = "Error!"
                        valueOne = 0.0
                        valueTwo = valueOne
                        state = State.BEGIN
                        operation = Operation.UNDEFINED
                        dotted = false
                    }
                    dotted = false
                }
                R.id.btnMinus -> {
                    state = State.DOESNTMATTER
                    operation = Operation.MINUS
                    if (tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    try {
                        valueOne = tvInput.text.toString().toDouble()
                    } catch (e: NumberFormatException) {
                        tvInput.text = "Error!"
                    }
                    if (tvInput.text.toString() == "Error!") {
                        tvInput.text = "Error!"
                        valueOne = 0.0
                        valueTwo = valueOne
                        state = State.BEGIN
                        operation = Operation.UNDEFINED
                        dotted = false
                    }
                    dotted = false
                }
                R.id.btnMultiply -> {
                    state = State.DOESNTMATTER
                    operation = Operation.MULTIPLY
                    if (tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    try {
                        valueOne = tvInput.text.toString().toDouble()
                    } catch (e: NumberFormatException) {
                        tvInput.text = "Error!"
                    }
                    if (tvInput.text.toString() == "Error!") {
                        tvInput.text = "Error!"
                        valueOne = 0.0
                        valueTwo = valueOne
                        state = State.BEGIN
                        operation = Operation.UNDEFINED
                        dotted = false
                    }
                    dotted = false
                }
                R.id.btnDivision -> {
                    state = State.DOESNTMATTER
                    operation = Operation.DIVIDE
                    if (tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    try {
                        valueOne = tvInput.text.toString().toDouble()
                    } catch (e: NumberFormatException) {
                        tvInput.text = "Error!"
                    }
                    if (tvInput.text.toString() == "Error!") {
                        tvInput.text = "Error!"
                        valueOne = 0.0
                        valueTwo = valueOne
                        state = State.BEGIN
                        operation = Operation.UNDEFINED
                        dotted = false
                    }
                    dotted = false
                }
                R.id.btnPow -> {
                    state = State.DOESNTMATTER
                    operation = Operation.POW
                    if (tvInput.text.toString() == "Infinity") {
                        tvInput.text = ""
                    }
                    try {
                        valueOne = tvInput.text.toString().toDouble()
                    } catch (e: NumberFormatException) {
                        tvInput.text = "Error!"
                    }
                    if (tvInput.text.toString() == "Error!") {
                        tvInput.text = "Error!"
                        valueOne = 0.0
                        valueTwo = valueOne
                        state = State.BEGIN
                        operation = Operation.UNDEFINED
                        dotted = false
                    }
                    dotted = false
                }
                R.id.btnPercent -> {
                    state = State.DOESNTMATTER
                    operation = Operation.PERCENT
                    if (tvInput.text.toString() == "Infinity") {
                        tvInput.text = "0"
                    }
                    try {
                        valueOne = tvInput.text.toString().toDouble()
                    } catch (e: NumberFormatException) {
                        tvInput.text = "Error!"
                    }
                    if (tvInput.text.toString() == "Error!") {
                        tvInput.text = "Error!"
                        valueOne = 0.0
                        valueTwo = valueOne
                        state = State.BEGIN
                        operation = Operation.UNDEFINED
                        dotted = false
                    } else {
                        tvInput.text = (valueOne * 0.01).toString()
                        dotted = false
                    }
                }
                R.id.btnRoot -> {
                    state = State.DOESNTMATTER
                    operation = Operation.SQRT
                    if (tvInput.text.toString() == "Infinity") {
                        tvInput.text = "0"
                    }
                    try {
                        valueOne = tvInput.text.toString().toDouble()
                    } catch (e: NumberFormatException) {
                        tvInput.text = "Error!"
                    }
                    if (tvInput.text.toString() == "Error!") {
                        tvInput.text = "Error!"
                        valueOne = 0.0
                        valueTwo = valueOne
                        state = State.BEGIN
                        operation = Operation.UNDEFINED
                        dotted = false
                    } else {
                        tvInput.text = sqrt(valueOne).toString()
                        dotted = false
                    }
                }
            }
        }
        btn0.setOnClickListener(calculatorListener)
        btn1.setOnClickListener(calculatorListener)
        btn2.setOnClickListener(calculatorListener)
        btn3.setOnClickListener(calculatorListener)
        btn4.setOnClickListener(calculatorListener)
        btn5.setOnClickListener(calculatorListener)
        btn6.setOnClickListener(calculatorListener)
        btn7.setOnClickListener(calculatorListener)
        btn8.setOnClickListener(calculatorListener)
        btn9.setOnClickListener(calculatorListener)
        btnDot.setOnClickListener(calculatorListener)
        btnMultiply.setOnClickListener(calculatorListener)
        btnDivision.setOnClickListener(calculatorListener)
        btnPlus.setOnClickListener(calculatorListener)
        btnMinus.setOnClickListener(calculatorListener)
        btnPow.setOnClickListener(calculatorListener)
        btnPercent.setOnClickListener(calculatorListener)
        btnRoot.setOnClickListener(calculatorListener)
        btnEqual.setOnClickListener(calculatorListener)
        btnClear.setOnClickListener {
            if (tvInput.text.toString() == "Error!") {
                tvInput.text = ""
            }
            when {
                tvInput.text.toString().isEmpty() -> {
                    //nothing happens
                }
                tvInput.text.length == 1 -> {
                    tvInput.text = ""
                }
                else -> { //if text length > 1
                    try {
                        tvInput.text = tvInput.text.toString().substring(0, tvInput.text.toString().length - 1)
                        valueOne = tvInput.text.toString().toDouble()
                    } catch (e: NumberFormatException) {
                        tvInput.text = ""
                    }
                }
            }
            dotted = tvInput.text.toString().contains(".")
        }
        btnClear.setOnLongClickListener(OnLongClickListener {
            if (tvInput.text.toString() == "Error!" || tvInput.text.toString() == "Infinity") {
                tvInput.text = ""
            }
            if (tvInput.text.toString().isEmpty()) {
                return@OnLongClickListener true
            }
            tvInput.text = ""
            valueOne = 0.0
            valueTwo = valueOne
            state = State.BEGIN
            operation = Operation.UNDEFINED
            dotted = false
            true
        })
        btnMinus.setOnLongClickListener(OnLongClickListener {
            if (tvInput.text.toString() == "Infinity") {
                tvInput.text = ""
            }
            if (tvInput.text.toString().isEmpty()) {
                return@OnLongClickListener true
            }
            try {
                valueOne = tvInput.text.toString().toDouble()
            } catch (e: NumberFormatException) {
                tvInput.text = "Error!"
            }
            if (tvInput.text.toString() == "Error!") {
                tvInput.text = "Error!"
                valueOne = 0.0
                valueTwo = valueOne
                state = State.BEGIN
                operation = Operation.UNDEFINED
                dotted = false
            } else {
                tvInput.text = (valueOne * -1).toString()
                valueOne *= -1
                dotted = false
            }
            true
        })
        btnEqual.setOnClickListener(View.OnClickListener {
            if (tvInput.text.toString() == "Error!") {
                tvInput.text = ""
            }
            try {
                valueTwo = tvInput.text.toString().toDouble()
            } catch (e: NumberFormatException) {
                tvInput.text = "Error!"
            }
            if (operation == Operation.PLUS) if (tvInput.text.toString() == "Error!") {
                tvInput.text = "Error!"
                return@OnClickListener
            } else tvInput.text = (valueOne + valueTwo).toString() else if (operation == Operation.MINUS) if (tvInput.text.toString() == "Error!") {
                tvInput.text = "Error!"
                return@OnClickListener
            } else tvInput.text = (valueOne - valueTwo).toString() else if (operation == Operation.MULTIPLY) if (tvInput.text.toString() == "Error!") {
                tvInput.text = "Error!"
                return@OnClickListener
            } else tvInput.text = (valueOne * valueTwo).toString() else if (operation == Operation.DIVIDE) when {
                tvInput.text.toString() == "Error!" -> {
                    tvInput.text = "Error!"
                    return@OnClickListener
                }
                valueTwo == 0.0 -> {
                    tvInput.text = "Error!"
                }
                else -> tvInput.text = (valueOne / valueTwo).toString()
            } else if (operation == Operation.POW) if (tvInput.text.toString() == "Error!") {
                tvInput.text = "Error!"
                return@OnClickListener
            } else tvInput.text = valueOne.pow(valueTwo).toString() else tvInput.text = "Error!"
            state = State.EQUAL
        })
    }
}