package com.example.cse226;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class FragMain extends AppCompatActivity implements ListFrag.ItemSelected {
TextView tvDescription;
//ArrayList<String> descriptions;
    String [] descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_main);
        tvDescription = findViewById(R.id.tvDescription);
        //descriptions = new ArrayList<String>(); (M1-one way is to create an arrayString..second is to paste the data of array xml by below line)
        descriptions = getResources().getStringArray(R.array.descriptions);
        /*descriptions.add("description for item1");
        descriptions.add("description for item2");
        descriptions.add("description for item3"); */
        if(findViewById(R.id.layout_portrait)!=null) //then phone is in portrait mode
        {
            FragmentManager fragmentManager= this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.detailFrag))
                    .show(fragmentManager.findFragmentById(R.id.listFrag))

                    .commit();
        }
        if(findViewById(R.id.layout_land)!=null) //then phone is in landscape mode
        {
           FragmentManager fragmentManager = this.getSupportFragmentManager();
           fragmentManager.beginTransaction()
                   .show(fragmentManager.findFragmentById(R.id.listFrag))
                   .show(fragmentManager.findFragmentById(R.id.detailFrag))
                   .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        //tvDescription.setText(descriptions.get(index));(for method 1)
    tvDescription.setText(descriptions[index]);
    if(findViewById(R.id.layout_portrait)!=null)
    {
        FragmentManager fragmentManager= this.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .hide(fragmentManager.findFragmentById(R.id.listFrag))
                .show(fragmentManager.findFragmentById(R.id.detailFrag))
                .addToBackStack(null) //for making the detailview go back to listview and not directly exit the activity
                .commit();
    }
    }
}
