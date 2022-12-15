package com.example.loyaltyfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity3 extends AppCompatActivity {
//    int cid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView textView6 = findViewById(R.id.textView6);
        TextView textView7 = findViewById(R.id.textView7);
        TextView textView8 = findViewById(R.id.textView8);
        TextView textView9 = findViewById(R.id.textView9);
        TextView textView10 = findViewById(R.id.textView10);
        TextView textView11 = findViewById(R.id.textView11);
        Intent intent = getIntent();
        RequestQueue queue = Volley.newRequestQueue(this);
        textView6.setText("\t"+"TXN_Ref" + " \t\tDate" + "\t\t\t\t\t\t\tPoints" + "\t\t\tTotal");


        String url1="http://10.0.2.2:8080/loyaltyfirst/Transactions.jsp?cid=1";
        StringRequest request1 = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] result = s.trim().split(",");
                String TXN_Ref = result[0];
                String date = result[1].substring(0,10);
                String points = result[2];
                String Total = result[3];
                textView7.setText("\t\t\t\t"+TXN_Ref+"\t\t\t\t" + date + "\t\t\t\t\t\t" + points + "\t\t\t\t\t" + Total);

            }
        },null);
        queue.add(request1);

        String url2="http://10.0.2.2:8080/loyaltyfirst/Transactions.jsp?cid=2";
        StringRequest request2 = new StringRequest(Request.Method.GET, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] result = s.trim().split(",");
                String TXN_Ref = result[0];
                String date = result[1].substring(0,10);
                String points = result[2];
                String Total = result[3];
                textView8.setText("\t\t\t\t"+TXN_Ref+"\t\t\t\t" + date + "\t\t\t\t\t\t" + points + "\t\t\t\t\t\t" + Total);
            }
        },null);
        queue.add(request2);

        String url3="http://10.0.2.2:8080/loyaltyfirst/Transactions.jsp?cid=3";
        StringRequest request3 = new StringRequest(Request.Method.GET, url3, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] result = s.trim().split(",");
                String TXN_Ref = result[0];
                String date = result[1].substring(0,10);
                String points = result[2];
                String Total = result[3];
                textView9.setText("\t\t\t\t"+TXN_Ref+"\t\t\t\t" + date + "\t\t\t\t\t\t" + points + "\t\t\t\t\t\t" + Total);
            }
        },null);
        queue.add(request3);

        String url4="http://10.0.2.2:8080/loyaltyfirst/Transactions.jsp?cid=4";
        StringRequest request4 = new StringRequest(Request.Method.GET, url4, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] result = s.trim().split(",");
                String TXN_Ref = result[0];
                String date = result[1].substring(0,10);
                String points = result[2];
                String Total = result[3];
                textView10.setText("\t\t\t\t"+TXN_Ref+"\t\t\t\t" + date + "\t\t\t\t\t\t" + points + "\t\t\t\t\t\t" + Total);
            }
        },null);
        queue.add(request4);

        String url5="http://10.0.2.2:8080/loyaltyfirst/Transactions.jsp?cid=5";
        StringRequest request5 = new StringRequest(Request.Method.GET, url5, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] result = s.trim().split(",");
                String TXN_Ref = result[0];
                String date = result[1].substring(0,10);
                String points = result[2];
                String Total = result[3];
                textView11.setText("\t\t\t\t"+TXN_Ref+"\t\t\t\t" + date + "\t\t\t\t\t\t" + points + "\t\t\t\t\t\t" + Total);
            }
        },null);
        queue.add(request5);
    }
}