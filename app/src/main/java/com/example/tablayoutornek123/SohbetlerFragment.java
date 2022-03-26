package com.example.tablayoutornek123;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class SohbetlerFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<Mesajlar> mesajlarListesi = new ArrayList<>();
    private SohbetlerAdapter sohbetlerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sohbetler, container, false);

        rv = view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        Mesajlar m1 = new Mesajlar(1,"ronaldinho","Ronaldinho","Biz bırakınca sahada şov yapan topçu kalmadı.","16.33");
        Mesajlar m2 = new Mesajlar(2,"beckham","David Beckham","Saçımı hangi şekil yaptırsam sence?","12.24");
        Mesajlar m3 = new Mesajlar(3,"neymar","Neymar","Abii partiye gidiyorum haberin olsun","10.00");
        Mesajlar m4 = new Mesajlar(4,"messi","Messi","Bu parise nerden bulaştık yaa :((","08.44");
        Mesajlar m5 = new Mesajlar(5,"ronaldo","C. Ronaldo","Bu manu daki futbolcular ney böyle ya bizim zamanımızda böylemiydi","06.12");
        Mesajlar m6 = new Mesajlar(6,"mbappe","Mbappe","Geçen çita ile yarıştım yarım saniye benden önde bitirdi ama onu da geçcem","04.24");
        Mesajlar m8 = new Mesajlar(8,"xavi","Xavi","Yavaş yavaş düzelcek Barcelona","01.54");
        Mesajlar m9 = new Mesajlar(9,"iniesta","Iniesta","Aga futbolun eski tadı kalmadı şimdi herkes para için oynuyor","01.54");
        Mesajlar m10 = new Mesajlar(9,"ibrahimovic","İbrahimoviç","EVRENİN EN İYİ FUTBOLCUSU DÖVMESİ YAPTIRDIM :)","01.32");


        mesajlarListesi.add(m1);
        mesajlarListesi.add(m2);
        mesajlarListesi.add(m3);
        mesajlarListesi.add(m4);
        mesajlarListesi.add(m5);
        mesajlarListesi.add(m6);

        mesajlarListesi.add(m8);
        mesajlarListesi.add(m9);
        mesajlarListesi.add(m10);


        sohbetlerAdapter = new SohbetlerAdapter(getActivity(), mesajlarListesi);
        rv.setAdapter(sohbetlerAdapter);


        return view;
    }
}