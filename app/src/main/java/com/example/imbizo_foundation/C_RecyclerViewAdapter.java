package com.example.imbizo_foundation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class C_RecyclerViewAdapter extends RecyclerView.Adapter<C_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<CoursesModel> coursesModels;

    public C_RecyclerViewAdapter(Context context, ArrayList<CoursesModel> coursesModels){
        this.context = context;
        this.coursesModels = coursesModels;

    }

    @NonNull
    @Override
    public C_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new C_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull C_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(coursesModels.get(position).getCourseName());
        holder.tvTime.setText(coursesModels.get(position).getCourseTime());
        holder.tvRating.setText(coursesModels.get(position).getCourseRating());
        holder.imageView.setImageResource(coursesModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return coursesModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvName, tvTime, tvRating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tv_Name);
            tvTime = itemView.findViewById(R.id.tv_Time);
            tvRating = itemView.findViewById(R.id.tv_Rating);
        }
    }
}


