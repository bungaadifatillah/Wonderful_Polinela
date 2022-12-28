package com.kevin.polinelainfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class JurusanEkbis extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurusan_ekbis);

        DatabasePolinelaInfo mDBHelper = new DatabasePolinelaInfo(this);
        SQLiteDatabase db = null;
        if (mDBHelper.openDatabase())
            db = mDBHelper.getReadableDatabase();

        ListView lv_daftar_prodi = findViewById(R.id.list);
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        String query_prodi = "SELECT kd_prodi,nm_prodi FROM ekbis ORDER BY kd_prodi";
        Cursor cursor_prodi = db.rawQuery(query_prodi, null);
        while (cursor_prodi.moveToNext()) {

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("kd_prodi", cursor_prodi.getString(0));
            map.put("nm_prodi", cursor_prodi.getString(1));
            list.add(map);
        }
        cursor_prodi.close();

        SimpleAdapter adapter = new SimpleAdapter(
                JurusanEkbis.this,
                list,
                R.layout.list_adapter,
                new String[]{"kd_prodi", "nm_prodi"},
                new int[]{R.id.kd_prodi, R.id.nm_prodi});
        lv_daftar_prodi.setAdapter(adapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(container.getContext(), AdministrasiPerpajakan.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(container.getContext(), ManajemenInformatika.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 2) {
                    Intent myIntent = new Intent(container.getContext(), PerjalananWisata.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 3) {
                    Intent myIntent = new Intent(container.getContext(), AgribisnisPangan.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 4) {
                    Intent myIntent = new Intent(container.getContext(), PengelolaanAgribisnis.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 5) {
                    Intent myIntent = new Intent(container.getContext(), AkuntansiPerpajakan.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 6) {
                    Intent myIntent = new Intent(container.getContext(), AkuntansiBisnisDigital.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 7) {
                    Intent myIntent = new Intent(container.getContext(), PengelolaanPerhotelan.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 8) {
                    Intent myIntent = new Intent(container.getContext(), TeknologiRekayasaInternet.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        };

        lv_daftar_prodi.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}