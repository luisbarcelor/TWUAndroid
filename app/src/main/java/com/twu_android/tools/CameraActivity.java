package com.twu_android.tools;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import com.twu_android.R;

public class CameraActivity extends AppCompatActivity {
    ImageView imageCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Button buttonCamera = findViewById(R.id.buttonCamera);
        imageCamera = findViewById(R.id.imageCamera);
        buttonCamera.setOnClickListener(v -> {
            try {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error");
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            Bundle bundle = data.getExtras();
            Bitmap photo = (Bitmap) bundle.get("data");
            imageCamera.setImageBitmap(photo);
        } catch (Exception e) {
            System.out.println("Error displaying image");
        }

    }
}