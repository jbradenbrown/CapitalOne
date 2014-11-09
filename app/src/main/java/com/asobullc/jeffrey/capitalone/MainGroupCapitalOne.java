package com.asobullc.jeffrey.capitalone;

import android.content.Intent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Kevin on 11/9/2014.
 */
public class MainGroupCapitalOne extends Activity {
    Button capOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.main_group_capital_one);
    }
}
