package com.msaasd.progresspro.features.launch

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.msaasd.progresspro.R
import ir.mahozad.android.PieChart

class History : AppCompatActivity() {
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()


        val pieChart = findViewById<PieChart>(R.id.pieChart)

        pieChart.slices = listOf(
            PieChart.Slice(0.6f, Color.BLUE),
            PieChart.Slice(0.4f, Color.GREEN)
        )
        pieChart.invalidate()


    }
}