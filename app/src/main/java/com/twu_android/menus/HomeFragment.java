package com.twu_android.menus;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.twu_android.R;
import com.twu_android.menus.home_categories.DesktopFragment;

public class HomeFragment extends Fragment {
    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        DesktopFragment desktopFragment = new DesktopFragment();
        FragmentManager fManager = getChildFragmentManager();
        fManager.beginTransaction()
                .replace(R.id.home_content, desktopFragment, "Desktop")
                .commit();

        LinearLayout upper_menu = view.findViewById(R.id.upper_menu);

        return view;
    }
}