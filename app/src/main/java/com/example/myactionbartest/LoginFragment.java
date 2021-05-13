package com.example.myactionbartest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment {

    EditText id;
    EditText pw;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        id = rootView.findViewById(R.id.loginidinput);
        pw = rootView.findViewById(R.id.loginpwinput);

        Button button = rootView.findViewById(R.id.loginbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginid = id.getText().toString();
                String loginpw = pw.getText().toString();

                MainActivity activity = (MainActivity) getActivity();
                activity.loginFragmentAction(0,loginid,loginpw);
            }
        });

        return rootView;
    }
}