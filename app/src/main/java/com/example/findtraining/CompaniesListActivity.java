package com.example.findtraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CompaniesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies_list);

        ArrayList<Company> companies = new ArrayList<>();

        companies.add(new Company(R.drawable.aes, 24.9602291, 46.7348702, "0112201350", "AEC", "Riyadh The training only for the following specialties (technical,  administrative)"));
        companies.add(new Company(R.drawable.alrajhibank, 24.7352233, 46.7831082, "920004550", "Alrajhi Bank", "Riyad The applicant must be a Saudi national  GPA of at least (2.5 out of 4)"));
        companies.add(new Company(R.drawable.aramco, 24.6751893, 46.6890379, "1129007", "Aramco", "Riyadh The applicant's GPA must not be less than 2.5 out of 4 The applicant must not have graduated from the university"));
        companies.add(new Company(R.drawable.kacst, 24.7122785, 46.647532, "114883555", "KACST", "RiyadhThe applicant must be a Saudi national  At least a GPA (3.75 out of 5)"));
        companies.add(new Company(R.drawable.mobily, 24.7123261, 46.6606642, "0560101100", "Mobily", "Minimum GPA (2.60 out of 4) for technical majors  English language proficiency"));
        companies.add(new Company(R.drawable.leannode, 24.8244833, 46.6566877, "59000099", "LeanNode", "Riyadh The training only for the following specialties (technical,  administrative) The duration of the program is 6 months"));
        companies.add(new Company(R.drawable.stc, 24.8245619, 46.6895185, "900", "STC", "Riyadh Required majors (computer engineering, business administration, finance)"));
        companies.add(new Company(R.drawable.sda, 24.7410539, 46.6353506, "920004696", "SDA", "Riyadh  The applicant must be a graduate"));

        CompaniesAdapter companiesAdapter = new CompaniesAdapter(companies, this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(companiesAdapter);
    }
}