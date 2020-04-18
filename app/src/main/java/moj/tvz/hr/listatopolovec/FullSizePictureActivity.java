package moj.tvz.hr.listatopolovec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FullSizePictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_size_picture);

        Intent intent = getIntent();
        String image = intent.getStringExtra("picture");

        ImageView imageView = findViewById(R.id.fullSizeImage);

        Glide.with(this).asBitmap().load(image).into(imageView);
    }
}
