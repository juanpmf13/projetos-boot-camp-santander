package me.dio.meuajudante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.dio.meuajudante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}