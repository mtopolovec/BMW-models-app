package moj.tvz.hr.listatopolovec;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ModelsDetailsActivity extends AppCompatActivity {

    private String image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.models_details);

        getIncomingIntent();

    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("model_image_url") && getIntent().hasExtra("details")) {
            image = getIntent().getStringExtra("model_image_url");
            String modelImageName = getIntent().getStringExtra("details");

            setModelImage(image,modelImageName);
        }
    }

    private void setModelImage(String modelImageUrl, String modelImageName) {

        TextView modelDetails = findViewById(R.id.model_details);
        modelDetails.setText(modelImageName);

        ImageView modelImage = findViewById(R.id.image_fullSize);
        Glide.with(this).asBitmap().load(modelImageUrl).into(modelImage);

        modelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModelsDetailsActivity.this, FullSizePictureActivity.class);

                Toast.makeText(v.getContext(), "Image" ,Toast.LENGTH_SHORT).show();
                intent.putExtra("picture",image);
                v.getContext().startActivity(intent);
            }
        });
    }

    public void openMoreDetails(View v) {
        String url = "https://www.bmw.hr/hr/all-models.html";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

}
