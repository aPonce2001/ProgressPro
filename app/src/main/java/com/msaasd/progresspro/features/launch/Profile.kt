package com.msaasd.progresspro.features.launch

import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.msaasd.progresspro.R

class Profile : AppCompatActivity(){
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()


        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        // Establece el valor máximo de progreso (100)
        progressBar.max = 100
        // Valor de progreso deseado (70)
        val targetProgress = 70
        // Crea un ObjectAnimator para animar el progreso
        val animator = ObjectAnimator.ofInt(progressBar, "progress", targetProgress)
        // Establece la duración de la animación en milisegundos
        animator.duration = 5000 // 5000 milisegundos (5 segundos)
        // Inicia la animación
        animator.start()
    }

}