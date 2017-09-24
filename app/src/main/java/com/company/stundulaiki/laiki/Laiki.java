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

package com.company.stundulaiki.laiki;


import java.util.ArrayList;

/**
 * Created by Kristers Leinerts on 09.09.2017.
 */

public class Laiki {

    private int stundasGarums = 40;
    private int sakumaLaiks = 510;

    private ArrayList<Integer> strapbrizuGarums = new ArrayList<Integer>();

    public Laiki() {
        strapbrizuGarums.add(10);
        strapbrizuGarums.add(10);
        strapbrizuGarums.add(15);
        strapbrizuGarums.add(15);
        strapbrizuGarums.add(25);
        strapbrizuGarums.add(10);
        strapbrizuGarums.add(10);
        strapbrizuGarums.add(5);
        strapbrizuGarums.add(5);
    }

    public int getStundasGarums() {
        return stundasGarums;
    }

    public void setStundasGarums(int stundasGarums) {
        this.stundasGarums = stundasGarums;
    }

    public int getStarpbrizaGarums(int starpbridis){
        return strapbrizuGarums.get(starpbridis - 1);
    }

    public void setStrapbrizaGarums(int starpbridis, int ilgums){
        this.strapbrizuGarums.set(starpbridis, ilgums);
    }

    public int getSakumaLaiks() {
        return sakumaLaiks;
    }

    public void setSakumaLaiks(int sakumaLaiks) {
        this.sakumaLaiks = sakumaLaiks;
    }
}
