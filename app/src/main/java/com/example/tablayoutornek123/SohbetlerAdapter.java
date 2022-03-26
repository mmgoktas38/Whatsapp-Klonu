package com.example.tablayoutornek123;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SohbetlerAdapter extends RecyclerView.Adapter<SohbetlerAdapter.CardViewHolder> {
    private Context mContext;
    private ArrayList<Mesajlar> gelenMesajlarListesi;

    public SohbetlerAdapter(Context mContext, ArrayList<Mesajlar> gelenMesajlarListesi) {
        this.mContext = mContext;
        this.gelenMesajlarListesi = gelenMesajlarListesi;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_sohbetler_tasarimi,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        String gelenMesaj = gelenMesajlarListesi.get(position).getMesajMesaj();

        holder.profile_imageGonderenResim.setImageResource(mContext.getResources().getIdentifier(gelenMesajlarListesi.get(position).getMesajResim(),"drawable",mContext.getPackageName()));
        holder.textViewGonderenBaslik.setText(gelenMesajlarListesi.get(position).getMesajGonderen());
        holder.textViewTarih.setText(gelenMesajlarListesi.get(position).getMesajTarih());

        if(gelenMesaj.length()<52){
            holder.textViewGonderenMesaj.setText(gelenMesaj);
        }else{
            holder.textViewGonderenMesaj.setText(gelenMesaj.substring(0,52)+"...");
        }


        holder.profile_imageGonderenResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Imageview Tıklandı",Toast.LENGTH_SHORT).show();
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "CardView Tıklandı",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return gelenMesajlarListesi.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private TextView textViewGonderenBaslik, textViewGonderenMesaj, textViewTarih;
        private ImageView profile_imageGonderenResim;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            textViewGonderenBaslik = itemView.findViewById(R.id.textViewGonderenBaslik);
            textViewTarih = itemView.findViewById(R.id.textViewTarih);
            textViewGonderenMesaj = itemView.findViewById(R.id.textViewGonderenMesaj);
            profile_imageGonderenResim = itemView.findViewById(R.id.profile_imageGonderenResim);
        }
    }
}
