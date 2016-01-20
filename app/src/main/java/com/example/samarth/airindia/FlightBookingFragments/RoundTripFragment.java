package com.example.samarth.airindia.FlightBookingFragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.samarth.airindia.R;
import com.example.samarth.airindia.RecyclerViewActivity;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RoundTripFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RoundTripFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoundTripFragment extends Fragment implements NumberPicker.OnValueChangeListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int x;


    private OnFragmentInteractionListener mListener;
    private Button btn_search_flight;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoundTripFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RoundTripFragment newInstance(String param1, String param2) {
        RoundTripFragment fragment = new RoundTripFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RoundTripFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_round_trip, container, false);


        final TextView departureDateTextView=(TextView)v.findViewById(R.id.departure_date_textView);
        departureDateTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog datePickerDialog, int i, int i2, int i3) {
                                Log.i("FromDate", i + ":" + i2 + ":" + i3);
                                departureDateTextView.setText(i + ":" + i2 + ":" + i3);
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );

                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
            }
        });
        final TextView arrivalDateTextView=(TextView)v.findViewById(R.id.arrival_date_textView);
        arrivalDateTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog datePickerDialog, int i, int i2, int i3) {
                                Log.i("FromDate", i + ":" + i2 + ":" + i3);
                                arrivalDateTextView.setText(i + ":" + i2 + ":" + i3);
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );

                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
            }
        });
        final RadioButton radioButton_round_trip=(RadioButton)v.findViewById(R.id.radioButton_round_trip);
        radioButton_round_trip.setChecked(true);
        final RadioButton radioButton_one_way=(RadioButton)v.findViewById(R.id.radioButton_one_way);

        radioButton_round_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //arrivalDateTextView.setEnabled(true);
                TranslateAnimation translateAnimation =new TranslateAnimation(175,0,0,0);
                translateAnimation.setDuration(1000);
                departureDateTextView.startAnimation(translateAnimation);
                translateAnimation.setFillAfter(true);
                arrivalDateTextView.animate().setDuration(2000);
                arrivalDateTextView.animate().alpha(1.0f);

                /*radioButton_round_trip.animate().translationX(0.5F);
                radioButton_round_trip.animate().setDuration(3000);
                radioButton_round_trip.animate().start();*/
                radioButton_one_way.setChecked(false);
            }
        });
        btn_search_flight=(Button)v.findViewById(R.id.btn_search_flight);

        btn_search_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        radioButton_one_way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //arrivalDateTextView.setEnabled(false);
              // arrivalDateTextView.setVisibility(View.GONE);
                arrivalDateTextView.animate().alpha(0.0f);
                arrivalDateTextView.animate().setDuration(600);
                TranslateAnimation translateAnimation =new TranslateAnimation(0,175,0,0);
                translateAnimation.setDuration(2000);
                translateAnimation.setFillAfter(true);
                departureDateTextView.startAnimation(translateAnimation);

                radioButton_round_trip.setChecked(false);
            }
        });
        final Button no_adults_button= (Button) v.findViewById(R.id.button_no_adults);
         no_adults_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 show(no_adults_button,1);

             }
         });
        final Button no_children_button = (Button) v.findViewById(R.id.button_no_children);
        no_children_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(no_children_button,2);
            }
        });
        final Button no_infants_button=(Button)v.findViewById(R.id.button_no_infants);
        no_infants_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(no_infants_button,3);
            }
        });
        return v;
    }

    public void show(final Button b, int buttonCode)
    {
/*
        final Dialog d = new Dialog(getActivity());
        d.setTitle("No of Adults");
        d.setContentView(R.layout.dialog);
        Button b1 = (Button) d.findViewById(R.id.button1);
        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(10);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(RoundTripFragment.this);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                no_adults_button.setText(np.getValue());
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();
        */
        String dialog_header_text="";
switch(buttonCode)
{
    case 1:dialog_header_text="No of Adults";
            break;
    case 2:dialog_header_text="No of Children";
        break;
    case 3:dialog_header_text="No of Infants";
        break;
}
        final Dialog d = new Dialog(getActivity());
        d.setTitle(dialog_header_text);
        d.setContentView(R.layout.dialog);
        Button b1 = (Button) d.findViewById(R.id.button1);
        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(10);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(RoundTripFragment.this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=np.getValue();
                Button no_adults_button2=(Button) v.findViewById(R.id.button_no_adults);
                b.setText(x+"");
                Log.i("Value",x+"");
                d.dismiss();

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        Log.i("value is",""+newVal);

        //final Button no_adults_button= (Button) v.findViewById(R.id.button);


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
