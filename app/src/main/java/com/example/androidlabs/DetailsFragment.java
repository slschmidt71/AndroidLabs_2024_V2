package com.example.androidlabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;




/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {
    //public void setTablet(boolean tablet) { isTablet = tablet; }

    private static final String ARG_NAME = "name";
    private static final String ARG_HEIGHT = "height";
    private static final String ARG_MASS = "mass";


    private String mName;
    private String mHeight;
    private String mMass;
    private Bundle dataFromActivity;

    //public void setTablet(boolean tablet) { isTablet = tablet; }

    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name Parameter 1.
     * @param height Parameter 2.
     * @param mass Parameter 3.
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(String name, String height, String mass) {

        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_HEIGHT, height);
        args.putString(ARG_MASS, mass);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataFromActivity = getArguments();
        assert dataFromActivity != null;
        mName = dataFromActivity.getString(MainActivity.ITEM_NAME);
        mHeight = dataFromActivity.getString(MainActivity.ITEM_HEIGHT);
        mMass = dataFromActivity.getString(MainActivity.ITEM_MASS);

        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
            mHeight = getArguments().getString(ARG_HEIGHT);
            mMass = getArguments().getString(ARG_MASS);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View result = inflater.inflate(R.layout.fragment_details,container,false);

        TextView nameView = (TextView)result.findViewById(R.id.tvNameFillMe);
        nameView.setText(dataFromActivity.getString(MainActivity.ITEM_NAME));


        TextView heightView = (TextView)result.findViewById(R.id.tvHeightFillMe);
        heightView.setText(dataFromActivity.getString(MainActivity.ITEM_HEIGHT));

        TextView massView = (TextView)result.findViewById(R.id.tvMassFillMe);
        massView.setText(dataFromActivity.getString(MainActivity.ITEM_MASS));


        return inflater.inflate(R.layout.fragment_details, container, false);
    }
}