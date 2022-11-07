package com.example.imbizo_foundation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class InspirationAdapter extends RecyclerView.Adapter<InspirationAdapter.MyViewHolder>  {

    private final RecyclerViewInterface inspiration_rv_interface;

    Context context;
    ArrayList<InspirationModel> inspirationModels;

    public InspirationAdapter(Context context, ArrayList<InspirationModel> inspirationModels, RecyclerViewInterface inspiration_rv_interface){
        this.context = context;
        this.inspirationModels = inspirationModels;
        this.inspiration_rv_interface = inspiration_rv_interface;
    }

    @NonNull
    @Override
    public InspirationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inspiration_recyclerview_row, parent, false);
        return new InspirationAdapter.MyViewHolder(view, inspiration_rv_interface);
    }

    @Override
    public void onBindViewHolder(@NonNull InspirationAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(inspirationModels.get(position).getEntrepreneurName());
        Glide.with(context).load(inspirationModels.get(position).getEntrepreneurURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return inspirationModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface inspiration_rv_interface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tv_Name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (inspiration_rv_interface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            inspiration_rv_interface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}