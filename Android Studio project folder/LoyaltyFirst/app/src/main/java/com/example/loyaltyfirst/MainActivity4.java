package com.example.loyaltyfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class MainActivity4 extends AppCompatActivity {
    String cid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        TextView textView12 = findViewById(R.id.textView12);
        TextView textview15 = findViewById(R.id.textView15);
        TextView textview17 = findViewById(R.id.textView17);
        textview17.setText("Select Transaction");
        Spinner spinner = findViewById(R.id.trfeSelector);
        TextView textview16 = findViewById(R.id.textView16);//PRODUCT NAME
        TextView textview22 = findViewById(R.id.textView22);//Date
        TextView textview23 = findViewById(R.id.textView23);//Points
        TextView textview24 = findViewById(R.id.textView24);//Quantity
        TextView textview25 = findViewById(R.id.textView25);//Points need



        textview15.setText("\t"+"Prod_name" + " \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tQuantity" + "\t\t\t\t\t\t\t\t\t\tPoints" + "\t");
        ArrayList<String> list=new ArrayList<String>();

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
                        list.add(result[i]);
                    }
                }
                catch (IndexOutOfBoundsException e){

                }
            }
        },null);
        queue.add(request);



        list.add("a2");
        list.add("a3");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tref=adapterView.getSelectedItem().toString();
                //final String[] display = {""};
                Toast.makeText(MainActivity4.this,"Transaction "+tref + " was selected.",Toast.LENGTH_LONG).show();
                String urlTref ="http://10.0.2.2:8080/loyaltyfirst/TransactionDetails.jsp?tref=%27" +tref + "%27";
                StringRequest request2 = new StringRequest(Request.Method.GET, urlTref, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        String display = "";
                        String date = "";
                        String points = "";
                        String p_Name = "";
                        String quantity = "";
                        String points_need = "";
                        String[] result = s.trim().split("#");
                        try{
                            for( int i = 0; i < result.length; i++){

                                String strSplit[] = result[i].trim().split(",");
                                date = strSplit[0];
                                points = strSplit[1];
                                p_Name +="\t\t\t\t"+strSplit[2]+"\n";
                                quantity +="\t\t\t\t"+strSplit[4] +"\n";
                                points_need += "\t\t\t\t"+strSplit[3] +"\n";
                                display += "\t\t\t\t"+strSplit[2]+ "\t\t\t\t"+strSplit[4]+"\t\t\t\t"+strSplit[3]+"\n";
                            }
                            textview22.setText(date.toString());
                            textview22.setMovementMethod( new ScrollingMovementMethod());
                            textview23.setText(points.toString());
                            textview23.setMovementMethod( new ScrollingMovementMethod());
                            textview16.setText(p_Name.toString());
                            textview16.setMovementMethod( new ScrollingMovementMethod());
                            textview24.setText(quantity.toString());
                            textview24.setMovementMethod( new ScrollingMovementMethod());
                            textview25.setText(points_need.toString());
                            textview25.setMovementMethod( new ScrollingMovementMethod());

                        }
                        catch (IndexOutOfBoundsException e){}

                    }
                },null);
                queue.add(request2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }
}