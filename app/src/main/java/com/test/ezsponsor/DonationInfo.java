package com.test.ezsponsor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class DonationInfo extends AppCompatActivity {

    private ListView list, completedList ;

    private String [] maintitle = {
        "Education",
        "1 month of food",
        "Medical"
    };

    private String [] subtitle = {
        "$400 raised of $1,500 goal\n150 donors",
        "$23 raised of $50 goal\n60 donors",
        "$75 raised of $100 goal\n51 donors"
    };

    private Integer [] progress = {25, 48, 75};

    private Integer [] imgid = {
        R.drawable.ic_notifications_black_24dp,
        R.drawable.ic_notifications_black_24dp,
        R.drawable.ic_notifications_black_24dp
    };

    private String [] completed_maintitle = {
        "Clothing",
        "Housing"
    };

    private String [] completed_subtitle = {
        "$30 raised of $30 goal\n150 donors",
        "$3,000 raised of $3,000 goal\n60 donors"
    };

    Integer [] completed_progress = {100, 100, 100};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CustomListView adapter=new CustomListView(this, maintitle, subtitle, imgid, progress, false);
        list=(ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
        Utility.setListViewHeightBasedOnChildren(list);

        CustomListView completedAdapter=new CustomListView(this, completed_maintitle, completed_subtitle, imgid, completed_progress, true);
        completedList=(ListView)findViewById(R.id.completedListView);
        completedList.setAdapter(completedAdapter);
        completedAdapter.notifyDataSetChanged();
        Utility.setListViewHeightBasedOnChildren(completedList);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
