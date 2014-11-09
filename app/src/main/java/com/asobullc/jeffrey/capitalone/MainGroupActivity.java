package com.asobullc.jeffrey.capitalone;

/**
 * Created by MacProJJ on 11/8/14.
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.asobullc.jeffrey.capitalone.R;

public class MainGroupActivity extends Activity {

    ImageView imageView1;
    RoundImage roundedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        setContentView(R.layout.main_group_view);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.red_hair_smile);
        roundedImage = new RoundImage(bm);
        imageView1.setImageDrawable(roundedImage);
    }
}