package me.dio.soccernews.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;

import me.dio.soccernews.R;
import me.dio.soccernews.data.SoccerNewsRepository;
import me.dio.soccernews.ui.MainActivity;
import me.dio.soccernews.databinding.FragmentNewsBinding;
import me.dio.soccernews.ui.Adapter.NewsAdapter;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;
    private NewsViewModel newsViewModel =
            new ViewModelProvider(this).get(NewsViewModel.class);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));

        findNews();

        setupState();

        binding.srlNews.setOnRefreshListener(this::findNews);

        return root;
    }

    private void setupState() {
        newsViewModel.getState().observe(getViewLifecycleOwner(), state -> {
            switch (state){
                case DONE:
                    binding.srlNews.setRefreshing(true);
                    //TODO incluir swipeRefreshLayout
                    break;
                case DOING:
                    binding.srlNews.setRefreshing(false);
                    //TODO finalizar swipeRefreshLayout
                    break;
                case ERROR:
                    binding.srlNews.setRefreshing(false);
                    Snackbar.make(binding.srlNews, "network error", Snackbar.LENGTH_SHORT).show();
                    //TODO finalizar swipeRefreshLayout
                    //TODO mostrar erro

            }
        });
    }

    private void findNews() {
        newsViewModel.getNews().observe(getViewLifecycleOwner(), news -> {
            binding.rvNews.setAdapter(new NewsAdapter(news, newsViewModel:: saveNews));
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}