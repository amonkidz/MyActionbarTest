package com.example.myactionbartest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class ShowTestFragment extends Fragment {

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_show_test, container, false);

        checkBox1 = rootView.findViewById(R.id.Q1_1);
        checkBox2 = rootView.findViewById(R.id.Q1_2);
        checkBox3 = rootView.findViewById(R.id.Q1_3);
        checkBox4 = rootView.findViewById(R.id.Q1_4);

        Button button = rootView.findViewById(R.id.endbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check1 = checkBox1.isChecked();
                boolean check2 = checkBox2.isChecked();
                boolean check3 = checkBox3.isChecked();
                boolean check4 = checkBox4.isChecked();

                AfterLoginActivity activity = (AfterLoginActivity) getActivity();
                if(check3 == true && check1 == false && check2 == false && check4 == false){
                    activity.answerView(true);
                } else {
                    activity.answerView(false);
                }
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
            }
        });

        Button button1 = rootView.findViewById(R.id.gobackbutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AfterLoginActivity activity = (AfterLoginActivity) getActivity();
                activity.Fragmentchange(1);
            }
        });

        return rootView;
    }
}