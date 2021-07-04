package com.example.responsi;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VirusViewModel extends ViewModel {
    private MainApiVirus mainApiVirus;
    private MutableLiveData<KasusData> listKasus = new MutableLiveData<KasusData>();

    public void setListKasus(){
        if(this.mainApiVirus == null){
            mainApiVirus = new MainApiVirus();
        }

        mainApiVirus.getApiVirus().getKasus().enqueue(new Callback<KasusResponse>() {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response) {
                KasusResponse responseKasus = response.body();
                if (responseKasus!=null && responseKasus.getKasusData()!=null){
                    KasusData kasusContentItems = responseKasus.getKasusData();
                    listKasus.postValue(kasusContentItems);

                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t) {

            }
        });
    }
    public MutableLiveData<KasusData> getKasus(){
        return listKasus;
    }
}
