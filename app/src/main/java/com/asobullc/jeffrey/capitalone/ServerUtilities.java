package com.asobullc.jeffrey.capitalone;

import android.app.Activity;
import android.os.Looper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Jeffrey on 11/8/14.
 */
public class ServerUtilities {

    class readWrite extends Thread {
        String write;
        PrintWriter out;
        BufferedReader in;
        MainActivity activity;

        public readWrite(String _write, Socket socket, MainActivity _activity) {
            write = _write;
            activity = _activity;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            }
            catch (Exception e) {
                System.exit(0);
            }
        }

        public void run () {
            Looper.prepare();
            String recv;
            out.println(write);
            try {
                recv = in.readLine();
                activity.inputHandler(recv);
            }
            catch (Exception e) {System.out.println(e.getMessage());}
        }

    }

}
