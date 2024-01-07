package com.medium.lovemusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.medium.lovemusic.activity.ChangePasswordActivity;
import com.medium.lovemusic.activity.SignInActivity;
import com.medium.lovemusic.constant.GlobalFuntion;
import com.medium.lovemusic.databinding.FragmentAccountBinding;
import com.medium.lovemusic.prefs.DataStoreManager;

public class AccountFragment extends Fragment {

    private FragmentAccountBinding mFragmentAccountBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentAccountBinding = FragmentAccountBinding.inflate(inflater, container, false);

        initListener();

        return mFragmentAccountBinding.getRoot();
    }

    private void initListener() {
        mFragmentAccountBinding.tvEmail.setText(DataStoreManager.getUser().getEmail());
        mFragmentAccountBinding.layoutSignOut.setOnClickListener(v -> onClickSignOut());
        mFragmentAccountBinding.layoutChangePassword.setOnClickListener(v -> onClickChangePassword());
    }

    private void onClickChangePassword() {
        GlobalFuntion.startActivity(getActivity(), ChangePasswordActivity.class);
    }

    private void onClickSignOut() {
        if (getActivity() == null) {
            return;
        }
        FirebaseAuth.getInstance().signOut();
        DataStoreManager.setUser(null);
        GlobalFuntion.startActivity(getActivity(), SignInActivity.class);
        getActivity().finishAffinity();
    }
}
