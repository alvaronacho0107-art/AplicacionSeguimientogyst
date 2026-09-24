package com.alvaro.seguimientodegarantiasyserviciostecnicos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alvaro.seguimientodegarantiasyserviciostecnicos.ui.login.LoginActivity
import com.alvaro.seguimientodegarantiasyserviciostecnicos.ui.clientes.ClientesActivity
import com.alvaro.seguimientodegarantiasyserviciostecnicos.ui.garantias.GarantiasActivity
import com.alvaro.seguimientodegarantiasyserviciostecnicos.ui.serviciostecnicos.ServiciosTecnicosActivity
import com.alvaro.seguimientodegarantiasyserviciostecnicos.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        findViewById<android.view.View>(R.id.botonClientes).setOnClickListener { open(ClientesActivity::class.java) }
        findViewById<android.view.View>(R.id.botonGarantias).setOnClickListener { open(GarantiasActivity::class.java) }
        findViewById<android.view.View>(R.id.botonServiciosTecnicos).setOnClickListener { open(ServiciosTecnicosActivity::class.java) }
        findViewById<android.view.View>(R.id.botonCerrarSesion).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun open(activity: Class<out AppCompatActivity>) {
        startActivity(Intent(this, activity))
    }
}

