package com.medium.lovemusic.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.medium.lovemusic.constant.Constant;
import com.medium.lovemusic.constant.GlobalFuntion;

public class MusicReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int action = intent.getExtras().getInt(Constant.MUSIC_ACTION);
        GlobalFuntion.startMusicService(context, action, MusicService.mSongPosition);
    }
}