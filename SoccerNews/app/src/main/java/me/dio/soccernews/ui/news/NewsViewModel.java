package me.dio.soccernews.ui.news;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.data.SoccerNewsRepository;
import me.dio.soccernews.data.local.AppDatabase;
import me.dio.soccernews.data.remote.SoccerNewsApi;
import me.dio.soccernews.domain.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    public enum State{
        DOING, DONE, ERROR;
    }

    private final MutableLiveData<List<News>> mNews = new MutableLiveData<>();
    private final MutableLiveData<State> state = new MutableLiveData<>();



    public NewsViewModel() {

        findNews();
    }

    public void findNews() {

        state.setValue(State.DOING);
        SoccerNewsRepository.getInstance().getRemoteApi().getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful()) {

                    mNews.setValue(response.body());
                    state.setValue(State.DONE);
                   // throw new RuntimeException("Test Crash");
                } else {
                    state.setValue(State.ERROR);
                    //TODO pensar em uma estratégia de tratamento de erros
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                state.setValue(State.ERROR);
                //TODO pensar em uma estratégia de tratamento de erros
            }
        });
    }


    public void saveNews(News news){
        AsyncTask.execute(()-> SoccerNewsRepository.getInstance().getLocalDb().newsDao().save(news));

    }
    public LiveData<List<News>> getNews() {
        return mNews;
    }
    public LiveData<State> getState() {
        return state;
    }
}