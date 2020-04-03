package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.movie.MovieDiscoverResultsItem;

import java.util.ArrayList;

public class MovieDiscoverAdapter extends RecyclerView.Adapter<MovieDiscoverAdapter.ViewHolder> {
    //untuk mengambil gambar online
    private static String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w185/";
    private Context context;

    public MovieDiscoverAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<MovieDiscoverResultsItem> movieDiscoverResultsItems = new ArrayList<>();
    //mengambil data dari resultItem
    public void setData(ArrayList<MovieDiscoverResultsItem> item){
        movieDiscoverResultsItems.clear();
        movieDiscoverResultsItems.addAll(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //megambil gambar online dari moviedb dan memasukannya ke ImageView Thumbnail
        Glide.with(context).load(BASE_IMAGE_URL+movieDiscoverResultsItems.get(position).getPosterPath())
        .into(holder.ivThumbnail);
        //mengambil judul
        holder.judul.setText(movieDiscoverResultsItems.get(position).getTitle());
        holder.rate.setText(String.valueOf(movieDiscoverResultsItems.get(position).getVoteAverage()));
    }

    @Override
    public int getItemCount() {
        return movieDiscoverResultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbnail;
        TextView judul,rate;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.thumbnail);
            judul = itemView.findViewById(R.id.tvTitle);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            rate = itemView.findViewById(R.id.rating);
        }
    }
}
