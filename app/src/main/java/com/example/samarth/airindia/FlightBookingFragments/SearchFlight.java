package com.example.samarth.airindia.FlightBookingFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.samarth.airindia.R;

/**
 * Created by samarth on 5/1/16.
 */
public class SearchFlight extends Fragment implements RadioButton.OnClickListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_flight, container, false);
        v.findViewById(R.id.radio_one_way).setOnClickListener(this);
        v.findViewById(R.id.radio_round_trip).setOnClickListener(this);

return v;
    }

    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.radio_one_way:
                if (checked)
                    Log.i("RadioButtonSelected", "One Way");
                break;
            case R.id.radio_round_trip:
                if (checked)
                    Log.i("RadioButtonSelected","Round Trip");

                break;
        }
    }
}