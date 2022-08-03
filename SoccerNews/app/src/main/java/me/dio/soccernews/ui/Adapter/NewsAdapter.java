package me.dio.soccernews.ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.dio.soccernews.R;
import me.dio.soccernews.databinding.NewsItemBinding;
import me.dio.soccernews.domain.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> news;

    private FavoriteListener favoriteListener;
    public NewsAdapter(List<News>news, FavoriteListener favoriteListener){

        this.news = news;
        this.favoriteListener=favoriteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News  news = this.news.get(position);
        holder.binding.tvTitle.setText(news.getTitle());
        holder.binding.tvDescription.setText(news.getDescription());
        Context context =  holder.itemView.getContext();
        Picasso.get()
                .load(news.getImage())
                .centerCrop()
                .resize(360,300)
                .into(holder.binding.ivThumbnail);
        //implementação da funcionalidade de "Abrir link"

        holder.binding.btnOpenLink.setOnClickListener(view -> {

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(news.getLink()));
            context.startActivity(i);
        });
        //implementação da funcionalidade de compartilhar
        holder.binding.ivShare.setOnClickListener(view -> {

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT,news.getTitle());
            i.putExtra(Intent.EXTRA_TEXT,news.getLink());
            holder.itemView.getContext().startActivity(Intent.createChooser(i,"Share via"));


        });
        //implementação da funcionalidade de favoritar(o evento será instanciado pelo fragmento)
        holder.binding.ivFavorite.setOnClickListener( view ->{
            news.setFavorite(!news.getFavorite())  ;
            this.favoriteListener.clickFavorite(news);
            notifyItemChanged(position);
        });

        int favoritecolor= news.getFavorite()? R.color.purple_700 : R.color.teal_700;
                holder.binding.ivFavorite.setColorFilter(context. getResources().getColor(favoritecolor));
    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder{

        private final NewsItemBinding binding;

        public ViewHolder(NewsItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public interface FavoriteListener {
        void clickFavorite(News news);
    }
}
