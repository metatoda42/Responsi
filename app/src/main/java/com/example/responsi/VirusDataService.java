package com.example.responsi;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;

public class VirusDataService {
    Context context;

    public VirusDataService(Context ctx) {
        this.context = ctx;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String[] konten);
    }
    //Fungsi untuk mendapatkan data covid
    public void getQuoteContent(final VolleyResponseListener volleyResponseListener){
        String url ="https://covid19-public.digitalservice.id/api/v1/rekapitulasi_v2/jabar/kumulatif";


        // Request a string response from the provided URL.
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONArray>() {
                   JSONArray data;
                   String[] kasus;
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = response.length()-1; i>=0; i--) {
                            try {
                                data.put(response.get(i));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        try {
                            JSONArray quoteContent = data;
                            for(int i = 0; i<6; i++){
                                kasus[i] = quoteContent.getString(i);
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

    }
}
