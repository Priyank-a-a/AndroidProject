package com.example.cse226;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class ListFrag extends ListFragment {
    ItemSelected activity;

  public interface ItemSelected
  {
      void onItemSelected(int index);
  }
    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (ItemSelected) context;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // ArrayList<String> data = new ArrayList<>();
        String[] data = getResources().getStringArray(R.array.pieces);
        /*data.add("1. This is item1");
        data.add("2. This is item2");
        data.add("3. This is item3");*/
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        if(this.getActivity().findViewById(R.id.layout_land)!=null) //if the phone is not in portrait mode, i.e , in landscape mode
        {
            activity.onItemSelected(0);
        }
        //activity.onItemSelected(0); (this makes the first item already clicked)
        //getActivity gets the activity attached to this activity, we dont have any such layout, its a by default layout, new arrayAdapter is a by default adapter..no the custom one

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
      activity.onItemSelected(position);

    }
}
