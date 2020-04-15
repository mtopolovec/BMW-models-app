package moj.tvz.hr.listatopolovec;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ModelsDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.models_details);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("model_image_url") && getIntent().hasExtra("details")) {
            String modelImageUrl = getIntent().getStringExtra("model_image_url");
            String modelImageName = getIntent().getStringExtra("details");

            setModelImage(modelImageUrl,modelImageName);
        }
    }

    private void setModelImage(String modelImageUrl, String modelImageName) {

        TextView modelDetails = findViewById(R.id.model_details);
        modelDetails.setText(modelImageName);

        ImageView modelImage = findViewById(R.id.image_fullSize);
        Glide.with(this).asBitmap().load(modelImageUrl).into(modelImage);
    }
}
