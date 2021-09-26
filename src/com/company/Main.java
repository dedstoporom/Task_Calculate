package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String str;
        System.out.print("INPUT:");
        Scanner sc=new Scanner(System.in);
        str=sc.nextLine();
	    new Logic(str);
    }
}
