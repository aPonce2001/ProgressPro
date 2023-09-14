package com.msaasd.progresspro.features.task

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.msaasd.progresspro.R

class TaskActivity : AppCompatActivity() {
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()


        val listView: ListView = findViewById(R.id.listTask)
        // Datos de ejemplo (puedes reemplazarlos con tus propios datos)
        val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        // Crear un adaptador personalizado
        val adapter = ArrayAdapter<String>(this, R.layout.list_item, R.id.textViewTask, items)
        // Establecer el adaptador en el ListView
        listView.adapter = adapter

    }

}