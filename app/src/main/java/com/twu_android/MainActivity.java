package com.twu_android;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.twu_android.menus.StoreFragment;
import com.twu_android.menus.ProfileFragment;
import com.twu_android.menus.ToolsFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BottomNavigationView nav_bar = findViewById(R.id.nav_bar);

//      FRAGMENTS
        StoreFragment storeFragment = new StoreFragment();
        ToolsFragment toolsFragment = new ToolsFragment();
        ProfileFragment profileFragment = new ProfileFragment();
//      FRAGMENTS END

        FragmentManager fManager = getSupportFragmentManager();
        fManager.beginTransaction()
                .replace(R.id.content_view, storeFragment, "Fragment")
                .commit();

        nav_bar.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.store) {
                fragment = storeFragment;
            } else if (itemId == R.id.tools) {
                fragment = toolsFragment;
            } else if (itemId == R.id.profile) {
                fragment = profileFragment;
            }

            if (fragment != null) {
                fManager.beginTransaction()
                        .replace(R.id.content_view, fragment, "Fragment")
                        .commit();
            }

            return true;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}