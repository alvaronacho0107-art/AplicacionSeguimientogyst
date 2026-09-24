package com.alvaro.seguimientodegarantiasyserviciostecnicos.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alvaro.seguimientodegarantiasyserviciostecnicos.MainActivity
import com.alvaro.seguimientodegarantiasyserviciostecnicos.R
import com.google.firebase.analytics.FirebaseAnalytics

class LoginActivity : AppCompatActivity() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        val username = findViewById<EditText>(R.id.inputUsuario)
        val password = findViewById<EditText>(R.id.inputContrasena)
        val error = findViewById<TextView>(R.id.textoErrorLogin)
        val login = {
            if (username.text.toString().trim() == "admin" && password.text.toString().trim() == "1234") {
                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, Bundle().apply {
                    putString(FirebaseAnalytics.Param.METHOD, "local")
                })
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                error.text = "Credenciales incorrectas. Usa admin / 1234."
                error.visibility = android.view.View.VISIBLE
            }
        }
        findViewById<Button>(R.id.botonIngresar).setOnClickListener { login() }
        password.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) { login(); true } else false
        }
    }
}
