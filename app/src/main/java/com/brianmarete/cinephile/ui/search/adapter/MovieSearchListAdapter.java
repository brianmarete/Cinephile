package com.brianmarete.cinephile.ui.search.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.brianmarete.cinephile.R;
import com.brianmarete.cinephile.data.local.entity.MovieEntity;
import com.brianmarete.cinephile.databinding.MoviesListItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieSearchListAdapter extends RecyclerView.Adapter<MovieSearchListAdapter.CustomViewHolder> {

    private Activity activity;
    private List<MovieEntity> trailers;
    public MovieSearchListAdapter(Activity activity) {
        this.activity = activity;
        this.trailers = new ArrayList<>();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        MoviesListItemBinding itemBinding = MoviesListItemBinding.inflate(layoutInflater, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(itemBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        MovieEntity trailer = getItem(i);
        customViewHolder.bindTo(trailer);
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    public List<MovieEntity> getItems() {
        return trailers;
    }

    public MovieEntity getItem(int position) {
        return trailers.get(position);
    }

    public void setItems(List<MovieEntity> trailers) {
        this.trailers = trailers;
        notifyDataSetChanged();
    }

    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private MoviesListItemBinding binding;
        public CustomViewHolder(MoviesListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;

            itemView.setLayoutParams(new RecyclerView.LayoutParams(new Float(width * 0.85f).intValue(),
                    RecyclerView.LayoutParams.WRAP_CONTENT));
        }

        public void bindTo(MovieEntity trailer) {
            Picasso.get().load(trailer.getPosterPath())
                    .placeholder(R.drawable.ic_placeholder)
                    .into(binding.image);
        }
    }
}
