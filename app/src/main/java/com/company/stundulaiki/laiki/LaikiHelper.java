package com.company.stundulaiki.laiki;

/**
 * Created by krist on 09.09.2017.
 */

public class LaikiHelper {

    public int GetHour(int minutes){
        return (int)Math.floor( minutes / 60);
    }

    public int GetMinutes(int minutes){
        return  minutes - (GetHour(minutes) * 60);
    }
}
