package com.example.samarth.airindia;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        private TextView time;
        private TextView cost;
        CardView cv;
        private TextView duration;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            cost = (TextView)itemView.findViewById(R.id.flight_cost);
            time = (TextView)itemView.findViewById(R.id.flight_time);
            duration=(TextView)itemView.findViewById(R.id.flight_duration);
        }
    }

    List<Person> persons;

    RVAdapter(List<Person> persons){
        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_activity, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.cost.setText(persons.get(i).flight_cost);
        personViewHolder.time.setText(persons.get(i).flight_time);
        personViewHolder.duration.setText(persons.get(i).flight_duration);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}