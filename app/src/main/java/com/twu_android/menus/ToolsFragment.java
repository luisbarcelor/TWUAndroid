package com.twu_android.menus;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.twu_android.MainActivity;
import com.twu_android.R;
import com.twu_android.tools.AudioActivity;
import com.twu_android.tools.CalculatorActivity;
import com.twu_android.tools.CameraActivity;


import java.util.ArrayList;

public class ToolsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tools, container, false);


        ConstraintLayout root = view.findViewById(R.id.tools_root);
        for (int i = 0; i < root.getChildCount(); i++) {
            View root_child = root.getChildAt(i);
            root_child.setTag(i);
            root_child.setOnClickListener(v -> {
                switch ((int) v.getTag()) {
                    case 1 -> {
                        Intent toAudio = new Intent(getActivity(), AudioActivity.class);
                        startActivity(toAudio);
                    }
                    case 2 -> {
                        Intent toAudio = new Intent(getActivity(), CalculatorActivity.class);
                        startActivity(toAudio);
                    }
                    case 3 -> {
                        Intent toAudio = new Intent(getActivity(), CameraActivity.class);
                        startActivity(toAudio);
                    }
                }
            });
        }

        return view;
    }

}