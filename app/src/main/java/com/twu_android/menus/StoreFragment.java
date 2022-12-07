package com.twu_android.menus;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.twu_android.R;
import com.twu_android.menus.home_categories.GeneralFragment;

public class StoreFragment extends Fragment {
    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store, container, false);

        GeneralFragment generalFragment = new GeneralFragment();
        FragmentManager fManager = getChildFragmentManager();
        fManager.beginTransaction()
                .replace(R.id.home_content, generalFragment, "General")
                .commit();

        LinearLayout upper_menu = view.findViewById(R.id.upper_menu);
        for (int i = 0; i < upper_menu.getChildCount(); i++) {
            View upper_menu_child = upper_menu.getChildAt(i);
            upper_menu_child.setTag(i);
            upper_menu_child.setOnClickListener(v -> {
                switch ((int) v.getTag()) {
                    case 0 -> System.out.println("Desktop");
                    case 1 -> System.out.println("Laptop");
                    case 2 -> System.out.println("Network");
                    case 3 -> System.out.println("Phones");
                    case 4 -> System.out.println("Peripherals");
                    case 5 -> System.out.println("Headphones");
                    case 6 -> System.out.println("Services");
                }
            });
        }

        return view;
    }
}