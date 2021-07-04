package com.example.responsi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainApiVirus {
    private Retrofit retrofit;

    public KasusRepository getApiVirus(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/v1";

        if(retrofit==null){
            retrofit = new Retrofit.
                    Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }
        return retrofit.create(KasusRepository.class);
    }
}