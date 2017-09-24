/*
 * Copyright 2017 Kristers Leinerts
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.company.stundulaiki;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.company.stundulaiki.laiki.Laiki;
import com.company.stundulaiki.laiki.LaikiHelper;
import com.company.stundulaiki.stundas.Stundas;

import java.util.ArrayList;

/**
 * Created by Kristers Leinerts on 09.09.2017.
 */

public class MainActivity extends AppCompatActivity {

    private int stunduSkaits = 9; //TODO: make this use a stunduSaraksts class
    private int diena = 1; // TODO: 17.09.2017 Make this use a getter for the day

    Laiki laiki;
    LaikiHelper laikiHelper;
    Stundas stunda;

    private ArrayList<TextView> stunduLaikiTextView = new ArrayList<TextView>();
    private ArrayList<TextView> stundasTextView = new ArrayList<TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        laiki = new Laiki();
        laikiHelper = new LaikiHelper();
        stunda = new Stundas();

        Log.d("STATE", "Running Stundas");

        stunduLaikiTextView.add((TextView) findViewById(R.id.stundasLaiks1));
        stunduLaikiTextView.add((TextView) findViewById(R.id.stundasLaiks2));
        stunduLaikiTextView.add((TextView) findViewById(R.id.stundasLaiks3));
        stunduLaikiTextView.add((TextView) findViewById(R.id.stundasLaiks4));
        stunduLaikiTextView.add((TextView) findViewById(R.id.stundasLaiks5));
        stunduLaikiTextView.add((TextView) findViewById(R.id.stundasLaiks6));
        stunduLaikiTextView.add((TextView) findViewById(R.id.stundasLaiks7));
        stunduLaikiTextView.add((TextView) findViewById(R.id.stundasLaiks8));
        stunduLaikiTextView.add((TextView) findViewById(R.id.stundasLaiks9));

        stundasTextView.add((TextView) findViewById(R.id.stunda1));
        stundasTextView.add((TextView) findViewById(R.id.stunda2));
        stundasTextView.add((TextView) findViewById(R.id.stunda3));
        stundasTextView.add((TextView) findViewById(R.id.stunda4));
        stundasTextView.add((TextView) findViewById(R.id.stunda5));
        stundasTextView.add((TextView) findViewById(R.id.stunda6));
        stundasTextView.add((TextView) findViewById(R.id.stunda7));
        stundasTextView.add((TextView) findViewById(R.id.stunda8));
        stundasTextView.add((TextView) findViewById(R.id.stunda9));

        Log.d("STATE", "Running loadTimes");
        loadTimes();
        Log.d("STATE", "Running loadStundas");
        loadStundas();
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

    public void loadTimes(){
        int currentTimeToShow = laiki.getSakumaLaiks();
        int endTime = currentTimeToShow + laiki.getStundasGarums();

        Log.d("STATE", "Getting text");
        for (int i = 1; i <= stunduSkaits; i++){
            getStunduLaikiTextView(i).setText(getTimeText(currentTimeToShow, endTime));
            currentTimeToShow = endTime + laiki.getStarpbrizaGarums(i);
            endTime = currentTimeToShow  + laiki.getStundasGarums();
        }
        for (int i = stunduSkaits + 1; i <= stunduLaikiTextView.size(); i++){
            getStunduLaikiTextView(i).setText("");
        }
    }

    private void loadStundas(){
        for (int i = 1; i <= stunduSkaits; i++){
            getStundasTextView(i).setText(stunda.getStunda(diena, i));
        }
        for (int i = stunduSkaits + 1; i <= stundasTextView.size(); i++){
            getStundasTextView(i).setText("");
        }
    }

    private String getTimeText(int startingTime, int endingTime){
        return laikiHelper.GetHour(startingTime) + ":" + laikiHelper.GetMinutes(startingTime) + " - " + laikiHelper.GetHour(endingTime) + ":" + laikiHelper.GetMinutes(endingTime);
    }

    public TextView getStunduLaikiTextView(int stunda) {
        return stunduLaikiTextView.get(stunda - 1);
    }

    public TextView getStundasTextView(int stunda) {
        return stundasTextView.get(stunda - 1);
    }
}
