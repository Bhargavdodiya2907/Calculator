package com.bhargav.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import javax.xml.xpath.XPathExpression

private val InputBinding.root: Any
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : AppCompatActivity() {

    private lateinit var binding: InputBinding
    var lastNumeric=false
    var stateError=false
    var lastDot=false

    private lateinit var expression: XPathExpression

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InputBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setContentView(root: Any) {
        TODO("Not yet implemented")
    }

    fun onAllclearClick(view: View) {}


    fun onDigitClick(view: View) {}


    fun onEqualClick(view: View) {}


    fun onOperatorClick(view: View) {}


    fun onClearClick(view: View) {}


    fun onBackClick(view: View) {}

    fun onEqual(){

        if (lastNumeric && !stateError){

            val txt = binding.dataTv.text.toString()
        }

    }
}