
package com.xxmassdeveloper.mpchartexample.notimportant;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.github.mikephil.charting.utils.Utils;
import com.xxmassdeveloper.mpchartexample.AnotherBarActivity;
import com.xxmassdeveloper.mpchartexample.BarChartActivity;
import com.xxmassdeveloper.mpchartexample.BarChartActivityMultiDataset;
import com.xxmassdeveloper.mpchartexample.HalfPieChartActivity;
import com.xxmassdeveloper.mpchartexample.LineChartActivity1;
import com.xxmassdeveloper.mpchartexample.LineChartActivity2;
import com.xxmassdeveloper.mpchartexample.ListViewBarChartActivity;
import com.xxmassdeveloper.mpchartexample.ListViewMultiChartActivity;
import com.xxmassdeveloper.mpchartexample.MultiLineChartActivity;
import com.xxmassdeveloper.mpchartexample.PieChartActivity;
import com.xxmassdeveloper.mpchartexample.PiePolylineChartActivity;
import com.xxmassdeveloper.mpchartexample.R;
import com.xxmassdeveloper.mpchartexample.RealtimeLineChartActivity;
import com.xxmassdeveloper.mpchartexample.ScrollViewActivity;
import com.xxmassdeveloper.mpchartexample.fragments.SimpleChartDemo;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        setTitle("Arquitectura 2");

        // initialize the utilities
        Utils.init(this);

        ArrayList<ContentItem> objects = new ArrayList<>();

        ////
        objects.add(0, new ContentItem("Temperatura"));

        objects.add(1, new ContentItem("Barra", "Ver informacion sensor temperatura"));
        objects.add(2, new ContentItem("Pie", "Ver informacion sensor humo"));
        objects.add(3, new ContentItem("Lineas", "Ver informacion sensor caudal"));

        ////
        objects.add(4, new ContentItem("Bar Charts"));

        objects.add(5, new ContentItem("Basic", "Simple bar chart."));
        objects.add(6, new ContentItem("Basic 2", "Variation of the simple bar chart."));
        objects.add(7, new ContentItem("Multiple", "Show multiple data sets."));

        ////
        objects.add(8, new ContentItem("Pie Charts"));

        objects.add(9, new ContentItem("Basic", "Simple pie chart."));
        objects.add(10, new ContentItem("Value Lines", "Stylish lines drawn outward from slices."));
        objects.add(11, new ContentItem("Half Pie", "180° (half) pie chart."));


        ////
        objects.add(12, new ContentItem("Scrolling Charts"));

        objects.add(13, new ContentItem("Multiple", "Various types of charts as fragments."));
        objects.add(14, new ContentItem("View Pager", "Swipe through different charts."));
        objects.add(15, new ContentItem("Tall Bar Chart", "Bars bigger than your screen!"));
        objects.add(16, new ContentItem("Many Bar Charts", "More bars than your screen can handle!"));

        ////
        objects.add(17, new ContentItem("Even More Line Charts"));

        objects.add(18, new ContentItem("Realtime", "Add data points in realtime."));

        MyAdapter adapter = new MyAdapter(this, objects);

        ListView lv = findViewById(R.id.listView1);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int pos, long arg3) {

        Intent i = null;

        switch (pos) {
            case 1:
                i = new Intent(this, LineChartActivity1.class);
                break;
            case 2:
                i = new Intent(this, MultiLineChartActivity.class);//
                break;
            case 3:
                i = new Intent(this, LineChartActivity2.class);
                break;
            case 5:
                i = new Intent(this, BarChartActivity.class);
                break;
            case 6:
                i = new Intent(this, AnotherBarActivity.class);
                break;
            case 7:
                i = new Intent(this, BarChartActivityMultiDataset.class);
                break;
            case 9:
                i = new Intent(this, PieChartActivity.class);//
                break;
            case 10:
                i = new Intent(this, PiePolylineChartActivity.class);//
                break;
            case 11:
                i = new Intent(this, HalfPieChartActivity.class);
                break;
            case 13:
                i = new Intent(this, ListViewMultiChartActivity.class);//
                break;
            case 14:
                i = new Intent(this, SimpleChartDemo.class);
                break;
            case 15:
                i = new Intent(this, ScrollViewActivity.class);//
                break;
            case 16:
                i = new Intent(this, ListViewBarChartActivity.class);
                break;
            case 18:
                i = new Intent(this, RealtimeLineChartActivity.class);//
                break;
        }

        if (i != null) startActivity(i);

        overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i;

        switch (item.getItemId()) {
            case R.id.VerNombres:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/PhilJay/MPAndroidChart"));
                startActivity(i);
                break;
        }
        return true;
    }
}
