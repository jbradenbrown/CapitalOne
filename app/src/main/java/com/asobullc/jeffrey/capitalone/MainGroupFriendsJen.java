package com.asobullc.jeffrey.capitalone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Kevin on 11/9/2014.
 */
public class MainGroupFriendsJen extends Activity implements View.OnClickListener {
    Button capOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.main_group_friends_jen_view);

        capOne = (Button) findViewById(R.id.editText1);
        capOne.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainGroupCapitalOne.class);
        startActivity(intent);
    }
}
