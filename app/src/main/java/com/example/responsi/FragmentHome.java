package com.example.responsi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {
    AdapterHome adapter;
    VirusDataService virusDataService;
    String[][] dataList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getQuote();

        adapter = new AdapterHome(getContext(),dataList);
        virusDataService = new VirusDataService(getContext());



        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void getQuote() {
        virusDataService.getKasus(new VirusDataService.VolleyResponseListener() {

            @Override
            public void onError(String message) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String[][] konten) {
                dataList = konten;
            }

        });
    }


}