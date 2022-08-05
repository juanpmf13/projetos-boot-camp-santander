package me.dio.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import me.dio.imcapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListener(binding);
    }

    private fun setListener(binding: ActivityMainBinding){
        binding.etCampoAltura.doAfterTextChanged { text ->

        }
        binding.etCampoPeso.doOnTextChanged { text,_ ,_ ,_  ->

        }
        binding.btnCalcular.setOnClickListener{
            calcularIMC(binding.etCampoPeso.text.toString(),binding.etCampoAltura.text.toString());
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloat()
        val altura =  altura.toFloat()
        if(peso!=null && altura!=null){
            val imc = peso/(altura*altura)
            binding.tvResultado.text= "valor do seu imc é : ${imc.toString()}".format(imc)
           // binding.tvResultado.setTextSize(24,24.0f)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w("lifecycle","entrei no onStarte")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle","entrei no onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecycle","entrei no onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.w("lifecycle","entrei no onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("lifecycle","entrei no onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("lifecycle","entrei no onDestroy")
    }
}