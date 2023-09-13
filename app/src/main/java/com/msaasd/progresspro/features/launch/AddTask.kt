package com.msaasd.progresspro.features.launch

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.msaasd.progresspro.R

class AddTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutContainer = findViewById<LinearLayout>(R.id.containerLayout)
        val addButton = findViewById<ImageButton>(R.id.addTask)

        val imageButtonCalendar = findViewById<ImageButton>(R.id.imageButton9)

        val imageButton = findViewById<ImageButton>(R.id.imageButton10)
        var isSelected = false

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

            // Aplicar el estilo de color personalizado al CheckBox
            checkBox.buttonTintList = getColorStateList(R.color.checkbox_color)

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

        imageButtonCalendar.setOnClickListener {
            // Obtiene la fecha actual para establecerla como fecha predeterminada en el DatePickerDialog
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Crea un DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                this,
                R.style.DatePickerStyle,
                DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                    // Aquí puedes manejar la fecha seleccionada
                    val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
                    // Haz lo que necesites con la fecha seleccionada, por ejemplo, mostrarla en un TextView
                    // textViewFecha.text = selectedDate
                },
                year,
                month,
                day
            )

            // Muestra el DatePickerDialog
            datePickerDialog.show()
        }

        imageButton.setOnClickListener {
            isSelected = !isSelected
            imageButton.isSelected = isSelected
        }
    }

}
