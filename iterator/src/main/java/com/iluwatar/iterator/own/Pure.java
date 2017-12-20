package com.iluwatar.iterator.own;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pure {

    private static final Logger LOGGER = LoggerFactory.getLogger(Pure.class);
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("Ankara");
        list.add("Mersin");
        list.add("Afyon");

        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            LOGGER.info(" > " + s );
        }
    }
}
