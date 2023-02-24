package com.example.lifecost.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.lifecost.R;
import com.example.lifecost.helper.Countries;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CountrySpinnerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountrySpinnerFragment extends Fragment {


    CountrySpinnerData dataBinder;

    @Override
    public void onAttach(Context ctx) {
        super.onAttach(ctx);
        dataBinder = (CountrySpinnerData) ctx;
    }

    public void passData(String data) {
        dataBinder.onDataPass(data);
    }


    public interface CountrySpinnerData {
        public void onDataPass(String data);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static String[] values = Countries.getAllCountries();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CountrySpinnerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CountrySpinnerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CountrySpinnerFragment newInstance(String param1, String param2) {
        CountrySpinnerFragment fragment = new CountrySpinnerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View v = inflater.inflate(R.layout.fragment_country_spinner, container, false);
        Spinner sp = (Spinner) v.findViewById(R.id.country_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                passData(sp.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //empty
            }
        });

        return v;

    }

}

