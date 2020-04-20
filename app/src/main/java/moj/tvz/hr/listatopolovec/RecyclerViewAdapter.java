package moj.tvz.hr.listatopolovec;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> modelImages = new ArrayList<>();
    private List<String> modelImageNames = new ArrayList<>();
    private List<String> modelImagesHighRes = new ArrayList<>();
    private List<String> modelImagesDetails = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(List<String> modelImages, List<String> modelImageNames, Context context,
                               List<String> modelImagesHighRes, List<String> modelImagesDetails) {
        this.modelImages = modelImages;
        this.modelImageNames = modelImageNames;
        this.context = context;
        this.modelImagesHighRes = modelImagesHighRes;
        this.modelImagesDetails = modelImagesDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).asBitmap().load(modelImages.get(position)).into(holder.listImage);

        holder.modelSeries.setText(modelImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(context,modelImageNames.get(position), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0,11);
                toast.show();
                Intent intent = new Intent(context, ModelsDetailsActivity.class);

                intent.putExtra("model_image_url",modelImagesHighRes.get(position));
                intent.putExtra("details",modelImagesDetails.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //If you want to add circle image view
        // you need to rename bellow ImageView to CircleImageView and turn it on in build.gradle module app!
        ImageView listImage;
        TextView modelSeries;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listImage = itemView.findViewById(R.id.listImage);
            modelSeries = itemView.findViewById(R.id.modelSeries);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
