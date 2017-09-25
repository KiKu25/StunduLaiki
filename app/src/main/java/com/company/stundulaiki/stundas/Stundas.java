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

package com.company.stundulaiki.stundas;

import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;



/**
 * Created by Kristers Leinerts on 16.09.2017.
 */

public class Stundas {

    private SparseArray<ArrayList> dienasDic;

    private ArrayList<String> pirmdiena;
    private ArrayList<String> otrdiena;
    private ArrayList<String> tresdiena;
    private ArrayList<String> ceturdiena;
    private ArrayList<String> piekdiena;
    private ArrayList<Integer> stunduSkaits;

    public Stundas() {
        dienasDic = new SparseArray<>();

        pirmdiena = new ArrayList<>();
        otrdiena = new ArrayList<>();
        tresdiena = new ArrayList<>();
        ceturdiena = new ArrayList<>();
        piekdiena = new ArrayList<>();
        stunduSkaits = new ArrayList<>();

        dienasDic.put(1, pirmdiena);
        dienasDic.put(2, otrdiena);
        dienasDic.put(3, tresdiena);
        dienasDic.put(4, ceturdiena);
        dienasDic.put(5, piekdiena);

        pirmdiena.add("pirma");
        pirmdiena.add(null);
        pirmdiena.add("tresa");
        pirmdiena.add("ceturta");
        pirmdiena.add("piekta");
        pirmdiena.add("sesta");
        pirmdiena.add("septita");
        pirmdiena.add("astota");
        pirmdiena.add("devita");

        otrdiena.add("2pirma");
        otrdiena.add("2otra");
        otrdiena.add("2tresa");
        otrdiena.add("2ceturta");
        otrdiena.add("2piekta");
        otrdiena.add("2sesta");
        otrdiena.add("2septita");
        otrdiena.add("2astota");
        otrdiena.add("2devita");

        updateStunduSkaits();
    }

    public String getStunda(int diena, int stunda){
        Log.d("STATE", "Getting Stunda. Diena: " + diena + " Stunda: " + stunda);
        stunda--;
        if (dienasDic.get(diena).get(stunda) == null){
            return "---";
        }else {
            return (String) dienasDic.get(diena).get(stunda);
        }
    }

    public void setStundas(int diena, ArrayList<String> stundas){
        dienasDic.get(diena).clear();
        dienasDic.get(diena).addAll(stundas);
    }

    public int getStunduSkaits(int diena){
        updateStunduSkaits();
        return stunduSkaits.get(diena - 1);
    }

    private void updateStunduSkaits(){
        stunduSkaits.clear();
        stunduSkaits.add(pirmdiena.size());
        stunduSkaits.add(otrdiena.size());
        stunduSkaits.add(tresdiena.size());
        stunduSkaits.add(ceturdiena.size());
        stunduSkaits.add(ceturdiena.size());
    }
}
