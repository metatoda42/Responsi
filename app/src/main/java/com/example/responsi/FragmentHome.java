package com.example.responsi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentHome extends Fragment {
    private AdapterHome adapterHome;
    private RecyclerView rvKasus;
    private VirusViewModel virusViewModel;


    public AdapterHome(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        adapter = new AdapterHome(getContext(),dataList);
        virusDataService = new VirusDataService(getContext());
        getKasus();

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        adapterHome = new AdapterHome(getContext());
        adapterHome.notifyDataSetChanged();

        rvKasus = view.findViewById(R.id.recyclerviewhome);

        virusViewModel = new VirusViewModel().get(VirusViewModel.class);
    }



}