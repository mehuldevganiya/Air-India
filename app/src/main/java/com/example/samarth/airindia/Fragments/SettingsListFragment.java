package com.example.samarth.airindia.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.samarth.airindia.FlightBookingFragments.RoundTripFragment;
import com.example.samarth.airindia.FlightBookingFragments.RoundTripFragment.OnFragmentInteractionListener;
import com.example.samarth.airindia.HomeActivity;
import com.example.samarth.airindia.R;
import com.example.samarth.airindia.SettingListItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.

 * Use the {@link SettingsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsListFragment extends Fragment {
    private ArrayList<SettingListItem> options;
    private ListView setting_list;
    private OptionsAdapter optionsAdapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsListFragment newInstance(String param1, String param2) {
        SettingsListFragment fragment = new SettingsListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SettingsListFragment() {
        // Required empty public constructor
    }

    class Holder{
        TextView option;
        ImageView icon;
    }

    class OptionsAdapter extends BaseAdapter
    {
        public OptionsAdapter() {
        }

        @Override
        public int getCount() {
            return options.size();
        }

        @Override
        public Object getItem(int position) {
            return options.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Holder holder;
            if(convertView==null)
            {
                LayoutInflater li = getActivity().getLayoutInflater();
                convertView = li.inflate(R.layout.settings_list_item, null);
                holder=new Holder();
                holder.option = (TextView) convertView.findViewById(R.id.optionName);
                holder.icon = (ImageView) convertView.findViewById(R.id.optionIcon);
                convertView.setTag(holder);
            }


            else
            {
                holder=(Holder) convertView.getTag();
            }

            SettingListItem item = (SettingListItem) getItem(position);
            holder.option.setText(item.getOption());
            holder.icon.setImageResource(item.getImageId());

            return convertView;
        }
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
        View rootView= inflater.inflate(R.layout.fragment_settings_list, container, false);
        setting_list = (ListView) rootView.findViewById(R.id.list_settings);

        options = new ArrayList<SettingListItem>();
        options.add(new SettingListItem("Login/Logout", R.drawable.ic_profile));
        options.add(new SettingListItem("About us", R.drawable.ic_add));
        options.add(new SettingListItem("Contact us",R.drawable.ic_add ));
        //options.add(new SettingListItem("Edit contact details",R.drawable.ic_add ));

        optionsAdapter = new OptionsAdapter();
        setting_list.setAdapter(optionsAdapter);
        setting_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            FragmentManager fragmentManager = getFragmentManager();
            Fragment fragment;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        Intent intent = new Intent(getActivity(), com.example.samarth.airindia.MainActivity.class);
                        startActivity(intent);
                        //fragment = (Fragment) new LoginFragment();
                        //fragmentManager.beginTransaction().replace(R.id.frame_settings, fragment).commit();
                        break;
                    case 1:
                        fragment = (Fragment) new AboutUsFragment();
                        fragmentManager.beginTransaction().replace(R.id.frame_settings, fragment).commit();
                        break;
                    case 2:
                        fragment = new AboutUsFragment();
                        fragmentManager.beginTransaction().replace(R.id.frame_settings,fragment).commit();
                }
            }
        });
        return rootView;
    }





}

