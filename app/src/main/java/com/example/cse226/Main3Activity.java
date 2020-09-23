package com.example.cse226;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
ImageView imageView1,imageView2,imageView3,imageView4;
Button button;
String name="",number = "", web = "",map="",mood ="";
    final int cc = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        button = findViewById(R.id.button);
        imageView1.setVisibility(View.GONE);
        imageView2.setVisibility(View.GONE);
        imageView3.setVisibility(View.GONE);
        imageView4.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Main4Activity.class);
                startActivityForResult(i,cc);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+number));
                startActivity(i);

            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+web));
                startActivity(i);

            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+map));
             startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== cc)
        {
          if(resultCode == RESULT_OK)
          {
              imageView1.setVisibility(View.VISIBLE);
              imageView2.setVisibility(View.VISIBLE);
              imageView3.setVisibility(View.VISIBLE);
              imageView4.setVisibility(View.VISIBLE);
              name = data.getStringExtra("name");
              number = data.getStringExtra("number");
              web = data.getStringExtra("web");
              map = data.getStringExtra("map");
              mood = data.getStringExtra("mood");
              if(mood.equals("happy"))
              {
                  imageView1.setImageResource(R.drawable.happy);
              }
              else if(mood.equals("neutral"))
              {
                  imageView1.setImageResource(R.drawable.neutral);
              }
              else
              {
                  imageView1.setImageResource(R.drawable.sad);
              }
          }
          else
          {
              Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
          }
        }
    }
}
