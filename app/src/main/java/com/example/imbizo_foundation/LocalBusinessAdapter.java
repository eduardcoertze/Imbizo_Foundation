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

public class LocalBusinessAdapter extends RecyclerView.Adapter<LocalBusinessAdapter.MyViewHolder> {

    private final RecyclerViewInterface inspiration_rv_interface;

    Context context;
    ArrayList<LocalBusinessModel> businessModels;

    public LocalBusinessAdapter(Context context, ArrayList<LocalBusinessModel> inspirationModels, RecyclerViewInterface inspiration_rv_interface) {
        this.context = context;
        this.businessModels = inspirationModels;
        this.inspiration_rv_interface = inspiration_rv_interface;
    }

    @NonNull
    @Override
    public LocalBusinessAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inspiration_recyclerview_row,parent,false);
        return new LocalBusinessAdapter.MyViewHolder(view,inspiration_rv_interface);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalBusinessAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(businessModels.get(position).getLocalBusinessName());
        Glide.with(context).load(businessModels.get(position).getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return businessModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

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
