package com.example.findtraining;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CompaniesAdapter extends RecyclerView.Adapter<CompaniesAdapter.CompaniesViewHolder> {
    private final ArrayList<Company> companies;
    private Context context;

    public CompaniesAdapter(ArrayList<Company> companies, Context context) {
        this.companies = companies;
        this.context = context;
    }

    @NonNull

    @Override
    public CompaniesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CompaniesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.companies, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CompaniesAdapter.CompaniesViewHolder holder, int position) {
        Company companyInfo = companies.get(position);
        holder.companyNameTv.setText(companyInfo.getName());
        holder.companyDescriptionTv.setText(companyInfo.getDescription());

        holder.companyImageView.setImageResource(companyInfo.getImage());

        holder.locationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapsActivity.class);
                intent.putExtra("name", companyInfo.getName());
                intent.putExtra("lat", companyInfo.getLatitude());
                intent.putExtra("lng", companyInfo.getLongitude());
                context.startActivity(intent);
            }
        });

        holder.phoneCallIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + companyInfo.getPhoneNumber()));
                context.startActivity(intent);
            }
        });

        holder.filesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("*/*");
                intent.setAction(Intent.ACTION_PICK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    class CompaniesViewHolder extends RecyclerView.ViewHolder {
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
            phoneCallIcon = itemView.findViewById(R.id.phoneCall_icon);
            filesIcon = itemView.findViewById(R.id.files_icon);
        }
    }
}
