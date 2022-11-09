package com.example.activityandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {
            val inputLen = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtWidth.text.toString().trim()

            var isEmptyFielda = false
            var isInvalidDouble = false

            if (TextUtils.isEmpty(inputLen)) {
                isEmptyFielda = true
                edtLength.error = "Field ini tidak boleh kosong"
            }
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFielda = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFielda = true
                edtHeight.error = "Field ini tidak boleh kosong"

            }


        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    private fun convertToDouble(str: String): Double? {
        return try {
            str.toDouble()
        } catch (e: NumberFormatException) {
            null
        }
    }
    companion object{
        private const val STATE_RESULT = "state_result"
    }
}

