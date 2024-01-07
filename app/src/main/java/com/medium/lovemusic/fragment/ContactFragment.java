package com.medium.lovemusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.medium.lovemusic.R;
import com.medium.lovemusic.adapter.ContactAdapter;
import com.medium.lovemusic.constant.GlobalFuntion;
import com.medium.lovemusic.databinding.FragmentContactBinding;
import com.medium.lovemusic.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {

    private ContactAdapter mContactAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentContactBinding fragmentContactBinding = FragmentContactBinding.inflate(inflater, container, false);

        mContactAdapter = new ContactAdapter(getActivity(), getListContact(), () -> GlobalFuntion.callPhoneNumber(getActivity()));
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        fragmentContactBinding.rcvData.setNestedScrollingEnabled(false);
        fragmentContactBinding.rcvData.setFocusable(false);
        fragmentContactBinding.rcvData.setLayoutManager(layoutManager);
        fragmentContactBinding.rcvData.setAdapter(mContactAdapter);

        return fragmentContactBinding.getRoot();
    }

    public List<Contact> getListContact() {
        List<Contact> contactArrayList = new ArrayList<>();
        contactArrayList.add(new Contact(Contact.FACEBOOK, R.drawable.ic_facebook));
        contactArrayList.add(new Contact(Contact.HOTLINE, R.drawable.ic_hotline));
        contactArrayList.add(new Contact(Contact.GMAIL, R.drawable.ic_gmail));
        contactArrayList.add(new Contact(Contact.SKYPE, R.drawable.ic_skype));
        contactArrayList.add(new Contact(Contact.YOUTUBE, R.drawable.ic_youtube));
        contactArrayList.add(new Contact(Contact.ZALO, R.drawable.ic_zalo));

        return contactArrayList;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mContactAdapter.release();
    }
}
