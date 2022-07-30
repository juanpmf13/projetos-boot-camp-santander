/*
package me.dio.simulator.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.PrimitiveIterator;

import me.dio.simulator.databinding.ActivityDetailBinding;
import me.dio.simulator.databinding.ActivityMainBinding;


public class DetailActivity extends AppCompatActivity {


    private  ActivityDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
*/

package me.dio.simulator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import me.dio.simulator.databinding.ActivityDetailBinding
import me.dio.simulator.domain.Match


class DetailActivity: AppCompatActivity() {

    object Extras{
        const val MATCH = "EXTRA_MATCH"
    }
    private lateinit var  binding : ActivityDetailBinding

    override fun  onCreate(  savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(getLayoutInflater())
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

       loadMatchFromExtra()
    }

    private fun loadMatchFromExtra() {
        intent?.extras?.getParcelable<Match>(Extras.MATCH)?.let {
            Glide.with(this).load(it.place.image).into(binding.ivPlace)
            supportActionBar?.title = it.place.name

            Glide.with(this).load(it.homeTeam.image).into((binding.ivHomeTeam))


            binding.tvDescription.text=it.description
            binding.tvHomeTeamName.text=it.homeTeam.name
            binding.rbHomeTeamStars.rating = it.homeTeam.stars.toFloat()
            if(it.homeTeam.score != null){
                binding.tvHomeTeamScore .text = it.homeTeam.score.toString()
            }

            Glide.with(this).load(it.awayTeam.image).into((binding.ivAwayTeam))
            binding.tvAwayTeamName.text=it.awayTeam.name
            binding.rbAwayTeamStars.rating = it.awayTeam.stars.toFloat()
            if(it.awayTeam.score != null){
                binding.tvAwayTeamScore .text = it.awayTeam.score.toString()
            }
        }
    }
}