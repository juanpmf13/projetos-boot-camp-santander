package me.dio.soccernews.data.remote;

import me.dio.soccernews.domain.News;
import retrofit2.http.GET;
import retrofit2.Call;
import java.util.List;

public interface SoccerNewsApi {

    @GET("news.json")
    Call<List<News>> getNews();
}
