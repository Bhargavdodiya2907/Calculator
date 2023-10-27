package com.bhargav.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import net.objecthunter.exp4j.ExpressionBuilder
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

    fun onAllclearClick(view: View) {
        binding.data_tv.text=""
        binding.result_tv.text=""
        stateError=false
        lastDot=false
        lastNumeric=false
        binding.resultv.visibility=View.GONE
    }


    fun onDigitClick(view: View) {

        if (stateError){
            binding.dataTv.text=(view as Button).text
            stateError=false
        }
        else{
            binding.dataTv.append((view as Button).text)
        }

        lastNumeric=true
        onEqual()
    }


    fun onEqualClick(view: View) {

        onEqual()
        binding.datatv.text=binding.resulttv.text.toString().drop(1)
    }


    fun onOperatorClick(view: View) {

        if (!stateError && lastNumeric){

            binding.datatv.append((view as Button).text)
            lastDot=false
            lastNumeric=false
            onEqual()
        }
    }


    fun onClearClick(view: View) {

        binding.datatv.text = ""
        lastNumeric=false
    }


    fun onBackClick(view: View) {

        binding.datatv.text=binding.datatv.text.toString().dropLast(1)

        try {
            val lastChar=binding.datatv.text.toString().last()

            if (lastChar.isDigit()){
                onEqual()
            }
        }
        catch (e:Exception){
            binding.resulttv.text=""
            binding.resulttv.visibility=View.GONE
            Log.e("last char error",e.toString())
        }
    }

    fun onEqual(){

        if (lastNumeric && !stateError){

            val txt = binding.dataTv.text.toString()

            expression=ExpressionBuilder(txt).build()

            try {

                val result= expression.evaluate()
                binding.resultTv.visibility=View.VISIBLE
                binding.resultTv.text="="+result.toString()

            }catch (ex : ArithmeticException){
                Log.e("evaluate error", ex.toString())
                binding.resultTv.text="Error"
                stateError=true
                lastNumeric=false
            }
        }

    }
}