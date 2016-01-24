package com.example.samarth.airindia.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.samarth.airindia.R;
import com.example.samarth.airindia.SettingListItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link RtiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RtiFragment extends Fragment {
    private ArrayList<String> options;
    private ListView rti_list;
    private ArrayAdapter<String> adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RtiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RtiFragment newInstance(String param1, String param2) {
        RtiFragment fragment = new RtiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public RtiFragment() {
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
        View rootView= inflater.inflate(R.layout.fragment_rti, container, false);
        rti_list = (ListView) rootView.findViewById(R.id.list_rti);
        options = new ArrayList<String>();
        options.add("Manual - 1 - Particulars of organization,functions and duties");
        options.add("Manual - 2 - Powers and duties of officers and employees");
        options.add("Manual - 3 - Procedure followed in decision-making process");
        options.add("Manual - 4 - Norms set for the discharge of functions");
        options.add("Manual - 5 - Rules, Regulations, Instructions, Manuals & Records used for discharging functions");
        options.add("Manual - 6 - A statement of the categories of documents that are held by it or under its control");
        options.add("Manual - 7 - Particulars of any arrangement that exists for consultation with or represented by the members of the public in relation to the formulation of itspolicy implementation");
        options.add("Manual - 8 - A statement of boards, council, committees and other bodies constituted");
        options.add("Manual - 9 - Directory of officers and employees");
        options.add("Manual - 10 - The monthly remuneration received by each of the officers and employees and the system of compensation as provided in the regulation");
        options.add("Manual - 11 - The budget allocated to each agency");
        options.add("Manual - 12 - The manner of execution of subsidy program");
        options.add("Manual - 13 - Particulars of recipients of concessions, permits or authorization");
        options.add("Manual -14 Information available in an electronic form");
        options.add("Manual - 15 - Particulars of facilities available to citizens for obtaining information");

        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,options );
        rti_list.setAdapter(adapter);
        return rootView;
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

}
