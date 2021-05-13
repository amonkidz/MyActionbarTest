package com.example.myactionbartest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.lang.annotation.Native;

public class ShowFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_show, container, false);

        Button button = rootview.findViewById(R.id.gologinafter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AfterLoginActivity activity = (AfterLoginActivity) getActivity();
                activity.Fragmentchange(1);
            }
        });

        return rootview;
    }
}