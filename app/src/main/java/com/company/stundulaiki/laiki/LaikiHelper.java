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

/**
 * Created by Kristers Leinerts on 09.09.2017.
 */

public class LaikiHelper {

    public String GetHour(int minutes){
        String time = Integer.toString ((int) Math.floor( minutes / 60));

        if (time.length() == 1)
            time = "0" + time;

        return time;
    }

    public String GetMinutes(int minutes){

        String time = Integer.toString( minutes - ((int)(Math.floor( minutes / 60)) * 60));

        if (time.length() == 1)
            time = "0" + time;

        return time;
    }
}
