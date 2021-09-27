package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Logic extends Init
{
    private Integer output;
    private String input;
    ArrayList<String> list=new ArrayList<>();
    Logic(String str) {
        input=str;
        Init init=new Init();
        init.init_arab();
        init.init_rome();
        System.out.print("OUTPUT:");
        try {
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void create_arab() throws Exception {
        init(Integer.valueOf(list.get(0)),Integer.valueOf(list.get(2)));
        System.out.println(output);
    }
    private void create_rome() throws Exception {
        Collection<String> collection=romeMap.keySet();
        init(romeMap.get(list.get(0)),romeMap.get(list.get(2)));
        if(output<0){throw new Exception("В системе нет отрицательных чисел!");}
            if(output<=10) {
                for(String key:collection) {
                    Object obj=romeMap.get(key);
                    if(obj.equals(output))
                    { System.out.println(key); }
                }
            } else if (output>10)
            {
                if(output==100) System.out.println("C");}
                int dec=output/10;
                for(String key:collection) {
                    Object obj=romeMap.get(key);
                    if(obj.equals(output-(dec*10))) {
                        if(output<20) System.out.println("X"+key);
                        switch (dec)
                        {
                            case 2:System.out.print("XX"+key);break;
                            case 3:System.out.print("XXX"+key);break;
                            case 4:System.out.print("XL"+key);break;
                            case 5:System.out.print("L"+key);break;
                            case 6:System.out.print("LX"+key);break;
                            case 7:System.out.print("LXX"+key);break;
                            case 8:System.out.print("LXXX"+key);break;
                            case 9:System.out.print("XC"+key);break;
                        }
                    }
                }
            }

    public void start() throws Exception {
        int f=0;
        int check=0;
        Pattern pattern=Pattern.compile("([A-Z]+|\\d+|-|/|\\+|\\*)");
        Matcher matcher=pattern.matcher(input);
        while (matcher.find()){ list.add(matcher.group());}
        while(f<list.size()) {
            if(!arabMap.containsKey(list.get(f))&!romeMap.containsKey(list.get(f))) {
                    f+=2;
                    throw new Exception("Неверные данные!");
            }
            if(arabMap.containsKey(list.get(f)))check--;
            else if(romeMap.containsKey(list.get(f)))check++;
            f+=2;
        }
        if(check==-2) create_arab();
        else if(check==2) create_rome();
        else throw new Exception("Используются одновременно разные системы счисления!");
    }

    void init(Integer i,Integer i1) throws Exception {
        if(list.get(1).equals("*"))
            output=i*i1;
        else if(list.get(1).equals("/"))
            output=i/i1;
        else if(list.get(1).equals("+"))
            output=i+i1;
        else if(list.get(1).equals("-"))
            output=i-i1;
        else
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
    }
}
