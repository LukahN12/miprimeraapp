package com.example.miprimeraaplicacin

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimeraaplicacin.databinding.ActivityMainBinding
import com.example.miprimeraaplicacin.databinding.VentanaAuxiliarBinding

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private  lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spinner.setSelection(0)
        initListeners()
    }

    private fun initListeners(){
        binding.buttonEnviar.setOnClickListener { comprobarDatos() }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TODO("Not yet implemented")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val edad = seekBar?.progress
                binding.textViewEdad.text = "Edad: $edad años"
            }
        })

    }

    private fun resetearDatos(){
        binding.editTextNombre.text.clear();
        binding.seekBar.progress = 0;
        binding.textViewEdad.text = "Edad: 0 años"
        binding.spinner.setSelection(0);
    }

    private fun comprobarDatos(){
        var comprobar = true;

        if (binding.editTextNombre.text.length < 3){
            binding.editTextNombre.setError("El nombre debe tener 3 o más caracteres")
            comprobar = false
        }

        if (binding.spinner.selectedItemPosition == 0){
            Toast.makeText(this,"Debes selecionar un idioma", Toast.LENGTH_SHORT).show()
            comprobar = false
        }

        if (comprobar){
            val intent = Intent(this, ActivityResult::class.java)
            intent.putExtra("DATA_NAME",binding.editTextNombre.text.toString())
            intent.putExtra("DATA_AGE",binding.seekBar.progress.toString())
            intent.putExtra("DATA_LANGUAGE",binding.spinner.selectedItem.toString())
            startActivity(intent)

        }
    }
}