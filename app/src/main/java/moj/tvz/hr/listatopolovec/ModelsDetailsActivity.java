package moj.tvz.hr.listatopolovec;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        PhotoAndDetails photoAndDetails = getPhotoAndDetails();
        setModelImage(photoAndDetails.getPhoto(),photoAndDetails.getDetails());
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

                Toast toast = Toast.makeText(v.getContext(), "Image" ,Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0,11);
                toast.show();

                PhotoAndDetails photoAndDetails = getPhotoAndDetails();
                intent.putExtra("picture",photoAndDetails.getPhoto());
                v.getContext().startActivity(intent);
            }
        });
    }

    public void openMoreDetails(View v) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        v.startAnimation(animation);
        String url = "https://www.bmw.hr/hr/all-models.html";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    private PhotoAndDetails getPhotoAndDetails() {
        Bundle data = getIntent().getExtras();
        PhotoAndDetails photoAndDetails = (PhotoAndDetails) data.getParcelable("photoAndDetails");
        return photoAndDetails;
    }

}
