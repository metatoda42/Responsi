package com.example.responsi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    private List<DataKasus> dataList;
    private Context context;

    //Dan Seterusnya, Lanjutin nanti lagi, mau makan

    public AdapterHome(Context context, List<DataKasus> dataList) {
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterHome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHome.ViewHolder holder, int position) {
        if(dataList!=null){
            holder.konfirmasi.setText(dataList.get(position).getCONFIRMATION());
            holder.sembuh.setText(dataList.get(position).getConfirmation_selesai());
            holder.meninggal.setText(dataList.get(position).getConfirmation_meninggal());
            holder.tanggal.setText(dataList.get(position).getTanggal());
        }


    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView konfirmasi;
        TextView sembuh;
        TextView meninggal;
        TextView tanggal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            konfirmasi = itemView.findViewById(R.id.textKonfirmasi);
            sembuh = itemView.findViewById(R.id.textSembuh);
            meninggal = itemView.findViewById(R.id.textMati);
            tanggal = itemView.findViewById(R.id.textTanggal);
        }
    }
}
