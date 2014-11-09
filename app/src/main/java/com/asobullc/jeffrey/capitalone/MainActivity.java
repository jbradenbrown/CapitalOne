package com.asobullc.jeffrey.capitalone;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class MainActivity extends Activity {
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    if(validateLogin() == true)
                        Toast.makeText(getBaseContext(), "Logged Successful", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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

    public boolean validateLogin() throws IOException {
        String host = "jet.codebasics.com";
        int port = 1566;

        Socket socket = new Socket(host, port);

        PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader serverIn = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        serverOut.write("v " + ((EditText)findViewById(R.id.username)).getText().toString() +
                " " + ((EditText)findViewById(R.id.password)).getText().toString());
    }
}
