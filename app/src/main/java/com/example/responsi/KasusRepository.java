package com.example.responsi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KasusRepository {

    @GET("rekapitulasi_v2/jabar/kumulatif")
    Call<KasusResponse> getKasus();
}
