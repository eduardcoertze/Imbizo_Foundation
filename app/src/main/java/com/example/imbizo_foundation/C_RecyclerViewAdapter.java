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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class C_RecyclerViewAdapter extends RecyclerView.Adapter<C_RecyclerViewAdapter.MyViewHolder>  {

    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<CoursesModel> coursesModels;

    public C_RecyclerViewAdapter(Context context, ArrayList<CoursesModel> coursesModels, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.coursesModels = coursesModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public C_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new C_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull C_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(coursesModels.get(position).getCourseName());
        holder.tvTime.setText(coursesModels.get(position).getCourseTime());

        Glide.with(context).load(coursesModels.get(position).getImageURl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return coursesModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName, tvTime;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tv_Name);
            tvTime = itemView.findViewById(R.id.tv_Time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}


