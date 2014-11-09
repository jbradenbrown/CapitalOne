package com.asobullc.jeffrey.capitalone;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

/**
 * Created by MacProJJ on 11/8/14.
 */
public class MainSettingsActivity extends Activity implements OnClickListener {
    Button done;
    public final static String monthlyIn = "com.asobullc.jeffrey.capitalone.monthlyIn";;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.main_settings_view);

        done = (Button) findViewById(R.id.doneButton);
        done.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainIndividualActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
