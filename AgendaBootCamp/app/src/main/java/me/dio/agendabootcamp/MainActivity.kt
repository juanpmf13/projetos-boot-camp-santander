package me.dio.agendabootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract

import android.widget.Button
import android.provider.CalendarContract.Events.*
import me.dio.agendabootcamp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        teste(binding)
    }
    fun teste(binding: ActivityMainBinding) {
        val btnSetEvent = binding.setEvent
        btnSetEvent.setOnClickListener {

            val intent = Intent(android.content.Intent.ACTION_INSERT)
                .setData(android.provider.CalendarContract.Events.CONTENT_URI)
                .putExtra(android.provider.CalendarContract.Events.TITLE, "Bootcamp everis")
                .putExtra(android.provider.CalendarContract.Events.EVENT_LOCATION, "ONLINE")
                .putExtra(
                    android.provider.CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                    java.lang.System.currentTimeMillis()
                )
                .putExtra(
                    android.provider.CalendarContract.EXTRA_EVENT_END_TIME,
                    java.lang.System.currentTimeMillis() + (60 * 60 * 1000)
                )

            startActivity(intent)
        }
    }
}