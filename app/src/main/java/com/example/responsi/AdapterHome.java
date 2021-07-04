package com.example.responsi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {

    private ArrayList<KasusContentItem> kasusContentItems = new ArrayList<>();
    Context context;

    public AdapterHome(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<KasusContentItem> items){
        kasusContentItems.clear();
        kasusContentItems.addAll(items);
        notifyDataSetChanged();
    }
    //Dan Seterusnya, Lanjutin nanti lagi, mau makan


    @NonNull
    @Override
    public AdapterHome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHome.ViewHolder holder, int position) {
        holder.tanggal.setText(kasusContentItems.get(position).getTanggal().toString());
        holder.konfirmasi.setText(kasusContentItems.get(position).getCONFIRMATION());
        holder.tewas.setText(kasusContentItems.get(position).getConfirmationMeninggal());
        holder.sembuh.setText(kasusContentItems.get(position).getConfirmationSelesai());
    }

    @Override
    public int getItemCount() {
        return kasusContentItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tanggal,konfirmasi, sembuh, tewas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tanggal = itemView.findViewById(R.id.textTanggal);
            konfirmasi = itemView.findViewById(R.id.textKonfirmasi);
            sembuh = itemView.findViewById(R.id.textSembuh);
            tewas = itemView.findViewById(R.id.textMati);
        }
    }
}