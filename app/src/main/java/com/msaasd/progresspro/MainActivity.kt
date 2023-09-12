package com.msaasd.progresspro

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutContainer = findViewById<LinearLayout>(R.id.containerLayout)
        val addButton = findViewById<ImageButton>(R.id.addTask)


        addButton.setOnClickListener(View.OnClickListener {
            // Crear elementos dinámicamente
            val linearLayoutItem = LinearLayout(this)
            linearLayoutItem.orientation = LinearLayout.HORIZONTAL
            linearLayoutItem.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            val checkBox = CheckBox(this)
            checkBox.text = "     "

            val editText = EditText(this)
            editText.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            editText.hint = "Description"

            // Agregar elementos al elemento LinearLayout secundario
            linearLayoutItem.addView(checkBox)
            linearLayoutItem.addView(editText)

            // Agregar el elemento LinearLayout secundario al contenedor principal
            linearLayoutContainer.addView(linearLayoutItem)
        }
        )
    }
}