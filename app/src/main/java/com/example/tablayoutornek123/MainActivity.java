package com.example.tablayoutornek123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    private ArrayList<Fragment> fragmentListesi = new ArrayList<>();
    private ArrayList<String> baslikListesi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        ActionBar actionBar;        // bunlar sayesinde toolbar rengini değiştirdik
        actionBar = getSupportActionBar();
        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#075E54"));
        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);


        getSupportActionBar().setElevation(0);    // bu tablayout ve toolbar arasında olan çizgiyi kaldırıyor

        // gösterilecek fragmentları fragmentListemize ekliyoruz
        fragmentListesi.add(new SohbetlerFragment());
        fragmentListesi.add(new DurumFragment());
        fragmentListesi.add(new AramalarFragment());

        FragmentState adapter = new FragmentState(this);
        viewPager2.setAdapter(adapter);

        // fragmentlar için başlık belirleyip listeye ekliyoruz
        baslikListesi.add("SOHBETLER");
        baslikListesi.add("DURUM");
        baslikListesi.add("ARAMALAR");

        // bu tablayout ile viewPager2 yi birlikte uyumu sağlıyor ve hangisine hangi başlık gelecek onu belirliyor
        new TabLayoutMediator(tabLayout, viewPager2,
                ((tab, position) -> tab.setText(baslikListesi.get(position)))).attach();

    }

    //  bu sınıf adapter sınıfımız recyclerView deki gibi aslında ayarlayan bura
    private class FragmentState extends FragmentStateAdapter{

        public FragmentState(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        // fragmenti getirir listedeki pozisyona göre
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentListesi.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentListesi.size();
        }
    }

    // toolbar menu oluşturduk
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_yeni_grup:
                Toast.makeText(getApplicationContext(), "Yeni Grup Tıklandı", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_yeni_toplu_mesaj:
                Toast.makeText(getApplicationContext(), "Yeni Toplu Mesaj Tıklandı", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_bagli_cihazlar:
                Toast.makeText(getApplicationContext(), "Bağlı Cihazlar Tıklandı", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_yildizli_mesajlar:
                Toast.makeText(getApplicationContext(), "Yıldızlı Mesajlar Tıklandı", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_ayarlar:
                Toast.makeText(getApplicationContext(), "Ayarlar Tıklandı", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_ara:
                Toast.makeText(getApplicationContext(), "Ara Tıklandı", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }

    }
}