package com.example.miprimeraaplicacin

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraaplicacin.databinding.VentanaAuxiliarBinding

class AuxActivity : AppCompatActivity() {
    private lateinit var binding : VentanaAuxiliarBinding
    private var name: String? = "nombre".toString()
    private var age : String? = "Edad".toString()
    private var language : String? = "Idioma".toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = VentanaAuxiliarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = intent.extras?.getString("DATA_NAME")
        age = intent.extras?.getString("DATA_AGE")
        language = intent.extras?.getString("DATA_LANGUAGE")

        binding.textViewNombre.text = name
        binding.textViewEdadAux.text = age
        binding.textViewIdioma.text = language



    }
}