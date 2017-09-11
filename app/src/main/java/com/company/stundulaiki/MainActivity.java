package com.company.stundulaiki;

import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.company.stundulaiki.laiki.Laiki;
import com.company.stundulaiki.laiki.LaikiHelper;

public class MainActivity extends AppCompatActivity {
    
    Laiki laiki = new Laiki();
    LaikiHelper laikiHelper = new LaikiHelper();

    public static TextView stundasLaiks1;
    
    public static TextView stunda;
    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        stundasLaiks1 = (TextView) findViewById(R.id.stundsLaiks1);

        stunda = (TextView) findViewById(R.id.stunda1);

        Log.d("STATE", "Runing loadeTimes");
        LoadTimes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void LoadTimes(){
        int currentTimeToShow = laiki.sakumaLaiks;
        int endTime = currentTimeToShow + laiki.stundasGarums;

        Log.d("STATE", "Geting text");
        stundasLaiks1.setText(laikiHelper.GetHour(currentTimeToShow) + ":" + laikiHelper.GetMinutes(currentTimeToShow) + " - " + laikiHelper.GetHour(endTime) + ":" + laikiHelper.GetMinutes(endTime));
    }
}
