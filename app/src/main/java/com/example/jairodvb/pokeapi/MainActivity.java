package com.example.jairodvb.pokeapi;

import android.graphics.Bitmap;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import java.util.Random;
import java.util.jar.Manifest;


public class MainActivity extends AppCompatActivity {


    ImageView img1;
    ImageView img2;
    Button bttn;
    String url1 = "http://pokeapi.co/api/v2/pokemon/5";
    String url2 = "http://pokeapi.co/api/v2/pokemon/6";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttn = (Button) findViewById(R.id.button);
        img1 = (ImageView) findViewById(R.id.imageView);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                        ImageRequest imgrequest = new ImageRequest(url1,

                                new Response.Listener<Bitmap>() {
                                    @Override
                                    public void onResponse(Bitmap response) {
                                        img1.setImageBitmap(response);
                                    }
                                }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse (VolleyError error)
                            {
                                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                                error.printStackTrace();
                            }
                        });

                        MySingleton.getMiInsta(MainActivity.this).addToRequestQue(imgrequest);
                }
            }
        });


    }
}
