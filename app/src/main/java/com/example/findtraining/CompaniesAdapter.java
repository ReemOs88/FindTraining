package com.example.findtraining;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CompaniesAdapter extends RecyclerView.Adapter<CompaniesAdapter.CompaniesViewHolder> {
  private   ArrayList<String> companies = new ArrayList<>();
  private   Context context;

    public CompaniesAdapter(ArrayList<String> companies, Context context) {
        this.companies = companies;
        this.context = context;
    }

    @NonNull

    @Override
    public CompaniesViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  CompaniesAdapter.CompaniesViewHolder holder, int position) {
     String companiesInfo = companies.get(position);
        holder.companyNameTv.setText(companiesInfo);
        holder.companyDescriptionTv.setText(companiesInfo);


    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    class CompaniesViewHolder extends RecyclerView.ViewHolder{
        ImageView companyImageView;
        TextView companyNameTv;
        TextView companyDescriptionTv;
        ImageView locationIcon;
        ImageView phoneCallIcon;
        ImageView filesIcon;

        public CompaniesViewHolder(@NonNull View itemView) {
            super(itemView);
            companyImageView = itemView.findViewById(R.id.company_pic);
            companyNameTv = itemView.findViewById(R.id.company_name);
            companyDescriptionTv = itemView.findViewById(R.id.company_description);
            locationIcon = itemView.findViewById(R.id.location_icon);
            phoneCallIcon= itemView.findViewById(R.id.phoneCall_icon);
            filesIcon =itemView.findViewById(R.id.files_icon);
        }
    }
}
