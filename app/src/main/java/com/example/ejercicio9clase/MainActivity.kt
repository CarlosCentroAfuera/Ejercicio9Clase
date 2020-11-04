package com.example.ejercicio9clase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val b1: Button = findViewById(R.id.b1)
    val et1: EditText = findViewById(R.id.et1)
    val et2: EditText = findViewById(R.id.et2)
    private val tv1: TextView = findViewById(R.id.tv1)

    private val focusListener = View.OnFocusChangeListener { vista, isFocused ->  if (isFocused) tv1.text = vista.tag.toString()}

    // Solo ponerlo si no te los añade Android Studio automáticamente.
    private val textWatcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            b1.isEnabled = et1.text.isNotEmpty() && et2.text.isNotEmpty()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAllListener()
    }

    private fun setAllListener(){
        et1.addTextChangedListener(textWatcher)
        et2.addTextChangedListener(textWatcher)
        b1.setOnClickListener {
            et1.text.append(et2.text)
            et2.text.clear()
        }

        et1.onFocusChangeListener = focusListener
        et2.onFocusChangeListener = focusListener
        b1.onFocusChangeListener = focusListener
    }
}