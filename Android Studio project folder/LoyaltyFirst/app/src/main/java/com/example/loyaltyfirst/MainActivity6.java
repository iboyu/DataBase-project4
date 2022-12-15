package com.example.loyaltyfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity6 extends AppCompatActivity {
    String cid = "";
    String tref = "";
    String familyid = "";
    String npoints = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        TextView textView13 = findViewById(R.id.textView13);
        textView13.setText("Select Transaction");
        TextView textView21 = findViewById(R.id.textView21);
        Spinner spinner = findViewById(R.id.spinner2);
        Button button7 = findViewById(R.id.button7);
        ArrayList<String> list=new ArrayList<String>();
        HashMap<String, String> points = new HashMap<String, String>();
        Intent intent = getIntent();
        cid = intent.getStringExtra("cid");
        RequestQueue queue = Volley.newRequestQueue(this);

        String urlTran = "http://10.0.2.2:8080/loyaltyfirst/Transactions.jsp?cid=" +cid;//GMU IP.
        StringRequest request = new StringRequest(Request.Method.GET, urlTran, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] result = s.trim().split(",");

                try{

                    for (int i = 0; i < result.length; i=+4 ){
                        tref = result[i];
                        points.put(tref, result[2]);
                        list.add(result[i]);
                    }
                }
                catch (IndexOutOfBoundsException e){

                }
            }
        },null);
        queue.add(request);



        list.add("");//Don't Remove this line of code.The app will Literary will stop working.


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tref=adapterView.getSelectedItem().toString();
                //final String[] display = {""};
                if(tref.length() != 0) {
                    Toast.makeText(MainActivity6.this, "The transaction select is " + tref, Toast.LENGTH_LONG).show();
                    String urlTref = "http://10.0.2.2:8080/loyaltyfirst/SupportFamilyIncrease.jsp?cid=" + cid + "&tref=%27" + tref + "%27";
                    StringRequest request2 = new StringRequest(Request.Method.GET, urlTref, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            if (s.length() != 0) {
                                String[] result = s.trim().split(",");
                                //textView21.setText(s);
                                familyid = result[0];
                                npoints = points.get(tref);
                                textView21.setText("\t\t\tTXN Points:\t\t" + result[2] + "\n\t\t\tFamily ID:\t\t" + result[0] + "\n\t\t\tFamily Percent:\t\t" + result[0]);
                            } else {
                                textView21.setText("\t\t\tTXN Points:\n\t\t\tFamily ID:\n\t\t\tFamily Percent:\t\t" );

                            }
                        }
                    }, null);
                    queue.add(request2);
                }
                else {
                    textView21.setText("\t\t\tTXN Points:\n\t\t\tFamily ID:\n\t\t\tFamily Percent:\t\t" );

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        button7.setText("ADD FAMILY POINTS");
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(npoints.length() > 0){
                    String urlFam = "http://10.0.2.2:8080/loyaltyfirst/FamilyIncrease.jsp?fid="+familyid+"&cid="+cid+"&npoints="+npoints;
                    StringRequest request2 = new StringRequest(Request.Method.GET, urlFam, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                              Toast.makeText(MainActivity6.this,npoints + "Total added to the members of family id: " +familyid ,Toast.LENGTH_LONG).show();

                        }
                    }, null);
                    queue.add(request2);

                }
                else {

                    Toast.makeText(MainActivity6.this,npoints + "Total added to the members of family id" +familyid ,Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}