package com.example.responsi;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VirusDataService {
    Context context;

    public VirusDataService(Context ctx) {
        this.context = ctx;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String[][] konten);
    }
    //Fungsi untuk mendapatkan data covid
    public void getKasus(final VolleyResponseListener volleyResponseListener){
        String url ="https://covid19-public.digitalservice.id/api/v1/rekapitulasi_v2/jabar/kumulatif";


        // Request a string response from the provided URL.
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    JSONArray data, kasus1;
                    JSONObject kasus2;
                    String[][] kasus;
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            data=response.getJSONArray("content");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for (int i = data.length()-1; i>=0; i--) {
                            try {
                                kasus1.put(data.getJSONObject(i));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        try {
                            //Ini Kodingan Amatiran, iya, tapi bodo lah...
                            //Intinya dari JsonArray dijadiin JsonObject trus dijadiin StringArray
                            // Dua Dimensi
                            JSONArray quoteContent = kasus1;
                            for(int i = 0; i<7; i++){
                                kasus2 = quoteContent.getJSONObject(i);
                                kasus[i][0]= kasus2.getString("CONFIRMATION");
                                kasus[i][1]= kasus2.getString("confirmation_selesai");
                                kasus[i][2]= kasus2.getString("confirmation_meninggal");
                                kasus[i][3]= kasus2.getString("tanggal");

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                        volleyResponseListener.onResponse(kasus);
                    }
                }, error -> {
            Toast.makeText(context, "JANCUK", Toast.LENGTH_SHORT).show();
            volleyResponseListener.onError("FFFFFFUUUUUUCCCKKKK");
        });
        Simpleton.getInstance(context).addToRequestQueue(request);
    }
}