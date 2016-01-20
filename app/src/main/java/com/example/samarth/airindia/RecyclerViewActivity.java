package com.example.samarth.airindia;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<Person> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("₹10,000", "12:30 -> 14:45","2hrs 15mins"));
        persons.add(new Person("₹12,000", "8:20 ->19:20","11hrs"));
        persons.add(new Person("₹8,500", "9 -> 10:45","1hrs 45mins"));

        persons.add(new Person("₹16,000", "11:30 -> 17:40","6hrs 10mins"));
        persons.add(new Person("₹2,500", "5 -> 20:15","15hrs 15mins"));
        persons.add(new Person("₹6,500", "6:30 -> 21:45","15hrs 15mins"));

        persons.add(new Person("₹22,000", "1:30 -> 17:40","16hrs 10mins"));
        persons.add(new Person("₹2000", "15:10 -> 20:15","5hrs 5mins"));
        persons.add(new Person("₹6500", "16:30 -> 21:45","6hrs 10mins"));


    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }
}
