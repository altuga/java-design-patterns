package com.iluwatar.iterator.own;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pure {

    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("Ankara");
        list.add("Mersin");
        list.add("Afyon");

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(" > " + s );
        }
    }
}
