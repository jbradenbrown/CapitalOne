package com.asobullc.jeffrey.capitalone;

/**
 * Created by MacProJJ on 11/8/14.
 */
import android.app.Activity;
import android.view.View;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.asobullc.jeffrey.capitalone.R;

public class MainGroupActivity extends Activity implements View.OnClickListener{
    Button friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.main_group_view);

        friends = (Button) findViewById(R.id.ATSMACButton);
        friends.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainGroupFriendsJen.class);
        startActivity(intent);
    }
}