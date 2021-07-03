package com.example.responsi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FragmentHome extends Fragment {
    AdapterHome adapter;
    VirusDataService virusDataService;
    List<DataKasus> dataList;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Context context;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerviewhome);
        virusDataService = new VirusDataService(getContext());
        callAPI();
        linearLayoutManager = new LinearLayoutManager(context);
        adapter = new AdapterHome(getActivity(),dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager((linearLayoutManager));

        return view;
    }

    public void callAPI() {
        Toast.makeText(getActivity(), "Yo!", Toast.LENGTH_SHORT).show();
        virusDataService.getKasus(new VirusDataService.VolleyResponseListener() {

            @Override
            public void onError(String message) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<DataKasus> konten) {
                Toast.makeText(getActivity(), "This is here!", Toast.LENGTH_SHORT).show();
                dataList = konten;
                adapter = new AdapterHome(getActivity(),dataList);
                adapter.notifyDataSetChanged();


            }

        });

    }


}