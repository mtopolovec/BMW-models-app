package moj.tvz.hr.listatopolovec;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> images = new ArrayList<>();
    private List<String> imageNames = new ArrayList<>();
    private List<String> modelImagesHighRes = new ArrayList<>();
    private List<String> modelImageDetails = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHighResImages();
        initImages();
    }

    private void initImages() {
        imageNames = Arrays.asList(getResources().getStringArray(R.array.models));
        images = Arrays.asList(getResources().getStringArray(R.array.car_models_images));

        initRecyclerView();
    }

    public void initHighResImages() {
        modelImageDetails = Arrays.asList(getResources().getStringArray(R.array.details));
        modelImagesHighRes = Arrays.asList(getResources().getStringArray(R.array.car_models_highRes));
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(images,imageNames,this,
                modelImagesHighRes,modelImageDetails);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
