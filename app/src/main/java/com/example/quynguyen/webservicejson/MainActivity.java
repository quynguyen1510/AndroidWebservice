package com.example.quynguyen.webservicejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridViewSV;
    TextView txtTittle;
    SinhVienAdapter adapter;
    ArrayList<SinhVien> arrSV;
    String urlData = "http://192.168.1.42:8080/androidwebservice/getsv.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        arrSV = new ArrayList<>();
        adapter = new SinhVienAdapter(arrSV,this,R.layout.custom_row);
        gridViewSV.setAdapter(adapter);
        getSinhVien(urlData);

    }
    public void AnhXa(){
        gridViewSV = findViewById(R.id.gridViewSV);
        txtTittle = findViewById(R.id.txtTittle);
    }

    //Lấy sinh viên từ phpMyadmin
    private void getSinhVien(final String urlData){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlData, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0 ; i < response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        arrSV.add(new SinhVien(
                                jsonObject.getInt("ID"),
                                jsonObject.getString("Ho_Ten"),
                                jsonObject.getString("Nam_Sinh"),
                                jsonObject.getString("Que_Quan")
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
}
