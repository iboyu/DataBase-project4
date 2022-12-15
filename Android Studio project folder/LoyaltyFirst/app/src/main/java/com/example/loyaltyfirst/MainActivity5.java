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

public class MainActivity5 extends AppCompatActivity {
    String cid = "";
    String last= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        TextView textView14 = findViewById(R.id.textView14);//Date and exchange
        TextView textView18 = findViewById(R.id.textView18);//Date and exchange Label
        TextView textView19 = findViewById(R.id.textView19);//Prize Description
        TextView textView20 = findViewById(R.id.textView20);
        textView20.setText("Select Prize ID");
        TextView textView27 = findViewById(R.id.textView27);//Prize Description Label
        Spinner spinner2 =  findViewById(R.id.prizeSpinner);
        textView18.setText("\t\tRedemption Date\t\t\t\t\t\t\t\t\t\t\t\tExchange Center");
        textView27.setText("\t\tPrizes Desc.\t\t\t\t\t\t\t\t\t\t\t\tPoints Needed");
        //textView18.setText("\t\t"+"Redemption Date" + " \t\t\t\t \t\t\t\t\t\t\t Exchange Center" + "\t");
        ArrayList<String> list=new ArrayList<String>();
        Intent intent = getIntent();
        cid = intent.getStringExtra("cid");
        RequestQueue queue = Volley.newRequestQueue(this);
        String urlPrize = "http://10.0.2.2:8080/loyaltyfirst/PrizeIds.jsp?cid=" + cid;
        StringRequest request = new StringRequest(Request.Method.GET, urlPrize, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] result = s.trim().split("#");
                try{
                    //
                    //  last += result[result.length];
                    for (int i = 0; i < result.length; i++ ){
                        list.add(result[i].toString());
                    }
                }
                catch (IndexOutOfBoundsException e){

                }
            }
        },null);
        queue.add(request);
        list.add("");



        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String prizeID =adapterView.getSelectedItem().toString();
                Toast.makeText(MainActivity5.this,"Prize Id: " +prizeID+" was selected." ,Toast.LENGTH_LONG).show();
                System.out.println("HELLO");

                //textView18.setText(prizeID);
                String urlRDetails = "http://10.0.2.2:8080/loyaltyfirst/RedemptionDetails.jsp?prizeid=%27"+prizeID+"%27&cid="+cid;
                StringRequest request1 = new StringRequest(Request.Method.GET, urlRDetails, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        String[] result = s.trim().split("#");
                        try{
                            String p_desc = "";
                            String exc_Center = "";
                            //String red_Date = "";
                            String p_needed = "";
                            for(int index = 0; index < result.length; index++){
                                String []strSplit =result[index].trim().split(",");
                                p_desc += "\t\t"+ strSplit[0]+ "\t\t\t\t\t\t\t\t\t\t\t\t\t" + strSplit[1]+"\n";
                                //p_needed += "\t\t"+strSplit[1]+ "\n";
                                exc_Center += "\t\t" + strSplit[2] + "\t\t\t\t\t" + strSplit[3]+"\n";


                            }
                           // p_desc += p_needed;
                            textView19.setText(p_desc);
                            textView19.setMovementMethod( new ScrollingMovementMethod());
                            textView14.setText(exc_Center);
                            textView14.setMovementMethod( new ScrollingMovementMethod());


                        }
                        catch (IndexOutOfBoundsException e){}

                    }
                },null);
                queue.add(request1);

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        textView14.setText("");
        textView19.setText("");



    }
}