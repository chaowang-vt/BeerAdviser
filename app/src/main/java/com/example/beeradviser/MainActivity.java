package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
        Spinner choose_color = (Spinner) findViewById(R.id.spinner_choose_color);
        String  beer_color = String.valueOf(choose_color.getSelectedItem());

        List<String> brandsList =  expert.getBrands(beer_color);

        StringBuilder beer_brands = new StringBuilder();
        for (String brand:brandsList) {
            beer_brands.append(brand);
            beer_brands.append("\n");
        }

        TextView show_brands = (TextView) findViewById(R.id.textview_show_brands);
        show_brands.setText(beer_brands);

    }
}