package com.medium.lovemusic.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.medium.lovemusic.databinding.ItemBannerSongBinding;
import com.medium.lovemusic.listener.IOnClickSongItemListener;
import com.medium.lovemusic.model.Song;
import com.medium.lovemusic.utils.GlideUtils;

import java.util.List;

public class BannerSongAdapter extends RecyclerView.Adapter<BannerSongAdapter.BannerSongViewHolder> {

    private final List<Song> mListSongs;
    public final IOnClickSongItemListener iOnClickSongItemListener;

    public BannerSongAdapter(List<Song> mListSongs, IOnClickSongItemListener iOnClickSongItemListener) {
        this.mListSongs = mListSongs;
        this.iOnClickSongItemListener = iOnClickSongItemListener;
    }

    @NonNull
    @Override
    public BannerSongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBannerSongBinding itemBannerSongBinding = ItemBannerSongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BannerSongViewHolder(itemBannerSongBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerSongViewHolder holder, int position) {
        Song song = mListSongs.get(position);
        if (song == null) {
            return;
        }
        GlideUtils.loadUrlBanner(song.getImage(), holder.mItemBannerSongBinding.imageBanner);
        holder.mItemBannerSongBinding.layoutItem.setOnClickListener(v -> iOnClickSongItemListener.onClickItemSong(song));
    }

    @Override
    public int getItemCount() {
        if (mListSongs != null) {
            return mListSongs.size();
        }
        return 0;
    }

    public static class BannerSongViewHolder extends RecyclerView.ViewHolder {

        private final ItemBannerSongBinding mItemBannerSongBinding;

        public BannerSongViewHolder(@NonNull ItemBannerSongBinding itemBannerSongBinding) {
            super(itemBannerSongBinding.getRoot());
            this.mItemBannerSongBinding = itemBannerSongBinding;
        }
    }
}
