package com.example.archanabongale.peoplestrimet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class PostActivity extends Activity {
    private ExpandableListView expListView;
    private ListAdapterExpandible adapter;

    // declare array List for all headers in list
    ArrayList<String> headersArrayList = new ArrayList<String>();

    // Declare Hash map for all headers and their corresponding values
    HashMap<String, ArrayList<String>> childArrayList = new HashMap<String, ArrayList<String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        expListView = (ExpandableListView) findViewById(R.id.expListView);
        // add headers values
        headersArrayList.add("Select a Line");
        headersArrayList.add("Select a Stop");

        // add add child content
        ArrayList<String> linesArrayList = new ArrayList<String>();
        linesArrayList.add("MAX Blue Line");
        linesArrayList.add("MAX Orange Line");
        linesArrayList.add("MAX Yellow Line");
        linesArrayList.add("MAX Green Line");
        linesArrayList.add("MAX Red Line");
        childArrayList.put("Select a Line", linesArrayList);

        ArrayList<String> stopArrayList = new ArrayList<String>();
        stopArrayList.add("Beaverton TC MAX Station");
        stopArrayList.add("Orenco MAX Station");
        stopArrayList.add("Merlo Rd");
        stopArrayList.add("Goose Hollow");
        stopArrayList.add("Rose Quarter");
        stopArrayList.add("HollyWood MAX Station");
        childArrayList.put("Select a Stop", stopArrayList);

        // declare adapter

        adapter = new ListAdapterExpandible(this, headersArrayList,
                childArrayList);

        expListView.setAdapter(adapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "Child is clicked", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // TODO: Do your stuff
                Toast.makeText(getApplicationContext(), "Group is Clicked", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                // TODO: Do your stuff
                Toast.makeText(getApplicationContext(), "Child is Collapsed", Toast.LENGTH_LONG).show();
            }
        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                // TODO: Do your stuff

                Toast.makeText(getApplicationContext(), "Child is Expanded", Toast.LENGTH_LONG).show();
            }
        });








    }


}
