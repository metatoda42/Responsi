package com.example.responsi;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class VirusDataService {
    List<DataKasus> dataKasuses;
    Context context;


    public VirusDataService(Context ctx) {
        this.context = ctx;
    }

    public interface VolleyResponseListener {

        void onError(String message);

        void onResponse(List<DataKasus> konten);
    }
    //Fungsi untuk mendapatkan data covid
    public void getKasus(final VolleyResponseListener volleyResponseListener){
        String url ="https://covid19-public.digitalservice.id/api/v1/rekapitulasi_v2/jabar/kumulatif";


        // Request a string response from the provided URL.
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null,
                response -> {
                        try {
                            JSONObject kasusObject = response;//objek
                            JSONArray kasusData = response.getJSONArray("content");
                            DataKasus kasus = new DataKasus();
                            kasus.setTanggal(kasusObject.getString("tanggal"));

                            dataKasuses.add(kasus);
                            Toast.makeText(context, "oooooooo", Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    volleyResponseListener.onResponse(dataKasuses);
                    Toast.makeText(context, "Over Here!!!", Toast.LENGTH_SHORT).show();
                }, error -> {
            Toast.makeText(context, "error semua", Toast.LENGTH_LONG).show();
            System.out.println(error);
            volleyResponseListener.onError("FFFFFFUUUUUUCCCKKKK");
        });
        Simpleton.getInstance(context).addToRequestQueue(request);
    }

//    public void getRujuk(final VolleyResponseListener volleyResponseListener) {
//        String url = "https://covid19-public.digitalservice.id/api/v1/rekapitulasi_v2/jabar/kumulatif";
//        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    JSONArray data;
//                    JSONObject rujuk1;
//                    String[][] rujuk;
//
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        try {
//                            JSONArray quoteContent = data;
//                            for (int i = 0; i < response.length(); i++) {
//                                rujuk1 = quoteContent.getJSONObject(i);
//                                rujuk[i][0] = rujuk1.getString("nama");
//                                rujuk[i][1] = rujuk1.getString("alamat");
//                                rujuk[i][2] = rujuk1.getString("longitude");
//                                rujuk[i][3] = rujuk1.getString("latitude");
//
//                            }
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//                        }
//                        volleyResponseListener.onResponse(rujuk);
//                    }
//                }, error -> {
//            Toast.makeText(context, "JANCUK", Toast.LENGTH_SHORT).show();
//            volleyResponseListener.onError("FFFFFFUUUUUUCCCKKKK");
//        });
//        Simpleton.getInstance(context).addToRequestQueue(request);
//    }

}
