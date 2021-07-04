package com.example.responsi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRujuk extends RecyclerView.Adapter<AdapterRujuk.ViewHolder> {
    private String[][] dataList;
    private Context context;

    //Dan Seterusnya, Lanjutin nanti lagi, mau makan

    public AdapterRujuk(Context context, String[][] dataList) {
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterRujuk.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_rujuk,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRujuk.ViewHolder holder, int position) {
        holder.nama.setText(dataList[0][position]);
        holder.alamat.setText(dataList[1][position]);

        holder.btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Kasih command buat buka map disini

// Search for restaurants in San Francisco
                Uri gmmIntentUri = Uri.parse("geo:"+dataList[2][position]+","+dataList[3][position]+"?q="+dataList[0][position]);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nama;
        TextView alamat;
        Button btnMap;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.textRS);
            alamat = itemView.findViewById(R.id.textAlamat);
        }
    }
}
