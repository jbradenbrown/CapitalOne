package com.asobullc.jeffrey.capitalone;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class MainActivity extends Activity implements OnClickListener {
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        Toast.makeText(getBaseContext(), "Login Successful", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainSettingsActivity.class);
        startActivity(intent);
      /*  try {
            if(validateLogin() == true) {
                Toast.makeText(getBaseContext(), "Login Successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainSettingsActivity.class);
                startActivity(intent);
            }
            else
                Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        } */
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
        String bool;
        int port = 1566;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Socket socket = new Socket(host, port);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);

        //InputStreamReader serverIn = new InputStreamReader(socket.getInputStream())

        serverOut.println("v " + ((EditText) findViewById(R.id.username)).getText().toString() +
                " " + ((EditText) findViewById(R.id.password)).getText().toString());

        //bool = serverIn.;
        //Scanner sc = new Scanner(socket.getInputStream());
        serverOut.flush();
        serverOut.close();
        bool = in.readLine();
        in.close();
        ((EditText) findViewById(R.id.username)).setText(bool);
        System.err.println(bool);

        socket.close();
        return true;
/*
        if(bool == "true")
            return true;
        else
            return false;
            */
    }
}
