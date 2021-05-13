package com.example.myactionbartest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class JoinFragment extends Fragment {

    EditText id;
    EditText pw;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_join, container, false);

        id = rootView.findViewById(R.id.joinidinput);
        pw = rootView.findViewById(R.id.joinpwinput);

        Button button = rootView.findViewById(R.id.joinbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String joinid = id.getText().toString();
                String joinpw = pw.getText().toString();

                MainActivity activity = (MainActivity) getActivity();
                activity.joinFragmentAction(0,joinid,joinpw);

            }
        });

        return rootView;
    }
}