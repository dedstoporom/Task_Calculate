package com.company;

import java.util.HashMap;
import java.util.Map;

public class Init
{
    public Map<String,Integer> arabMap=new HashMap<>();
    public Map<String,Integer> romeMap=new HashMap<>();
    Init()
    {
        init_rome();
        init_arab();
    }
    public void init_rome() {
        romeMap.put("I",1);
        romeMap.put("II",2);
        romeMap.put("III",3);
        romeMap.put("IV",4);
        romeMap.put("V",5);
        romeMap.put("VI",6);
        romeMap.put("VII",7);
        romeMap.put("VIII",8);
        romeMap.put("IX",9);
        romeMap.put("X",10);
    }
    public void init_arab() {
        arabMap.put("1", 1);
        arabMap.put("2", 2);
        arabMap.put("3", 3);
        arabMap.put("4", 4);
        arabMap.put("5", 5);
        arabMap.put("6", 6);
        arabMap.put("7", 7);
        arabMap.put("8", 8);
        arabMap.put("9", 9);
        arabMap.put("10", 10);
    }
}
