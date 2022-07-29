/*package me.dio.simulator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import me.dio.simulator.R
import me.dio.simulator.data.MatchesApi
import me.dio.simulator.data.MatchesApi2
import me.dio.simulator.databinding.ActivityMainBinding
import me.dio.simulator.domain.Match
import me.dio.simulator.ui.adapter.MatchesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityMainBinding
    private lateinit var matchesApi : MatchesApi2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("aqui","juan!!!!!!!!!!!!!!!")


        setupHttpClient()


        setupMatchesList()

        //setupMatchesRefresh()

        //setupFloatingActionButton()

    }

    private fun setupHttpClient() {
        val retrofit =  Retrofit.Builder()
            .baseUrl("https://juanpmf13.github.io/matches-simulator-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        matchesApi=retrofit.create(MatchesApi2::class.java)
    }

    private fun setupFloatingActionButton() {
        TODO("criar evento de click e simulação de partidas")
    }

    private fun setupMatchesRefresh() {
        TODO("Atualizar as partidas na ação de swipe")
    }

    private fun setupMatchesList() {
        binding.rvMatches.setHasFixedSize(true);
        binding.rvMatches.setLayoutManager( LinearLayoutManager(this));
       // binding.rvMatches.layoutManager(LinearLayoutManager(this))
       matchesApi.getMatches().enqueue(object : Callback<List<Match>>{
           override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {

                   if(response.isSuccessful){
                       var matches = response.body()
                       val matchesAdapter = MatchesAdapter(matches)
                       binding.rvMatches.adapter(matchesAdapter)
                       Log.d("SIMULATOR", "Deu tudo certo, voltaram partidas"+ matches !!.size)
                   }
                   else{
                       showErrorMessager()
                   }

           }

           override fun onFailure(call: Call<List<Match>>, t: Throwable) {
                showErrorMessager()
           }
       })
    }

    private fun showErrorMessager() {
        val snackbar = Snackbar.make(binding.fabSimulate, R.string.error_api,Snackbar.LENGTH_LONG).show()

    }
}

private fun RecyclerView.adapter(matchesAdapter: MatchesAdapter) {

}

private fun RecyclerView.layoutManager(linearLayoutManager: LinearLayoutManager): LinearLayoutManager {

    return LinearLayoutManager(context)
}

*/


package me.dio.simulator.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
 import androidx.recyclerview.widget.LinearLayoutManager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

import android.os.Bundle;

import android.util.Log;


import com.google.android.material.snackbar.Snackbar;


import java.util.List;
import java.util.Random;

import me.dio.simulator.R;
import me.dio.simulator.data.MatchesApi;
import me.dio.simulator.databinding.ActivityMainBinding;
import me.dio.simulator.domain.Match;
 import me.dio.simulator.ui.adapter.MatchesAdapter;
 import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding ;
private MatchesApi matchesApi ;
private MatchesAdapter matchesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupHttpClient();

        setupMatchesList();

        setupMatchesRefresh();

        setupFloatingActionButton();

        }

private void setupHttpClient() {
        Retrofit retrofit =  new Retrofit.Builder()
        .baseUrl("https://juanpmf13.github.io/matches-simulator-api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
        matchesApi=retrofit.create(MatchesApi.class);
        }

private void setupFloatingActionButton() {
        binding.fabSimulate.setOnClickListener(view-> view.animate().rotationBy(360).setDuration(1000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Random random = new Random();
                if(matchesAdapter != null)
                for (int i = 0 ; i < matchesAdapter.getItemCount();i++){
                    Match match = matchesAdapter.getMatches().get(i);
                    match.getHomeTeam().setScore(random.nextInt(match.getHomeTeam().getStars()+1));
                    match.getAwayTeam().setScore(random.nextInt(match.getAwayTeam().getStars()+1));
                    matchesAdapter.notifyItemChanged(i);
                }
            }
        }));
        }

    private void setupMatchesRefresh() {
        binding.srlMatches.setOnRefreshListener(this::findMatchesFromApi);
    }
private void  setupMatchesList() {
        binding.rvMatches.setHasFixedSize(true);

        binding.rvMatches.setLayoutManager(new LinearLayoutManager(this));
    findMatchesFromApi();
}

    private void findMatchesFromApi() {
        binding.srlMatches.setRefreshing(true);
        matchesApi.getMatches().enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(@NonNull Call<List<Match>> call, @NonNull Response<List<Match>> response) {
                if(response.isSuccessful()){
                    List<Match> matches = response.body();
                    matchesAdapter = new MatchesAdapter(matches);
                    binding.rvMatches.setAdapter(matchesAdapter);
                    assert matches != null;
                    Log.i("SIMULATOR","deu certo "+ matches.size());
                }
                else{
                    showErrorMessager();
                }
                binding.srlMatches.setRefreshing(false);
            }

            @Override
            public void onFailure(@NonNull Call<List<Match>> call, @NonNull Throwable t) {
                showErrorMessager();
                binding.srlMatches.setRefreshing(false);
            }
        });
    }

    private void showErrorMessager() {
       Snackbar.make(binding.fabSimulate, R.string.error_api,Snackbar.LENGTH_LONG).show();

        }
}

