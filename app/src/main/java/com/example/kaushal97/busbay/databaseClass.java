package com.example.kaushal97.busbay;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class databaseClass extends AppCompatActivity {
TextView show;
private static final int lst=100;
private Myadapter mAdapter;
private RecyclerView mNumberlist;
DrawerLayout mdrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_class);
        mdrawerLayout=findViewById(R.id.drawer_layout);

        //mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mdrawerLayout.closeDrawers();

                        switch(menuItem.getItemId()){
                            case R.id.route:

                            case R.id.gallery:
//                                searchData(d2.getCurrent(),d2.getTo());
                        }

                        return true;
                    }
                });

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);


        Intent intent=getIntent();
        String city=intent.getStringExtra("city");
        String station=intent.getStringExtra("initial");
        String rstation=intent.getStringExtra("finalx");
        database x=new database(this);
        //x.insertValues();
        //x.insertValuesx();
        StringBuilder s=x.searchValues(station,rstation,city);


            String out = s.toString();
            if(out.equals("")){
                Intent i=new Intent(this,MainActivity.class);
                startActivity(i);
                Toast toast=Toast.makeText(this,"No Bus Found",Toast.LENGTH_LONG);
                toast.show();

        }
        else{
                if(city.equals("Chandigarh")){
             int []imagesArray = {
                    R.drawable.bus1, R.drawable.bus2, R.drawable.bus3,
                    R.drawable.bus4,R.drawable.bus5,R.drawable.bus6,R.drawable.bus7,R.drawable.bus8,};
                     String[] sArray = out.split("\n");
                     mNumberlist = (RecyclerView) findViewById(R.id.re_list);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                    mNumberlist.setLayoutManager(layoutManager);
                    mNumberlist.setNestedScrollingEnabled(false);
                    mNumberlist.setHasFixedSize(true);
                    mAdapter = new Myadapter(sArray, imagesArray);
                    mNumberlist.setAdapter(mAdapter);
            }
            else{
                     int[]imagesArray = {
                           R.drawable.bkn1,R.drawable.bkn2,R.drawable.bkn3,R.drawable.bkn4,R.drawable.bkn5,R.drawable.bkn6,R.drawable.bkn7,R.drawable.bkn8,
                    };
                    String[] sArray = out.split("\n");
                    mNumberlist = (RecyclerView) findViewById(R.id.re_list);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                    mNumberlist.setLayoutManager(layoutManager);
                    mNumberlist.setNestedScrollingEnabled(false);
                    mNumberlist.setHasFixedSize(true);
                    mAdapter = new Myadapter(sArray, imagesArray);
                    mNumberlist.setAdapter(mAdapter);
                }


//        show=(TextView)findViewById(R.id.show);
//        if(s==null){show.setText("Bus Not Found");}
//        else{
//            show.setText(out);}





        }




    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mdrawerLayout.openDrawer(GravityCompat.START);
        return true;
    }
}

