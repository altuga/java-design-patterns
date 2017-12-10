package com.iluwatar.iterator.own;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RunTv {

    public static void main(String args[]) {
        List<String> channells = new ArrayList<String>();
        channells.add("A kanali");
        channells.add("B kanali");
        channells.add("C kanali");

        ConcreteTV concreteTV = new ConcreteTV(channells);

        ChannelIterator it = concreteTV.getIterator();
        while(it.hasNext()){

            System.out.println(" > " + it.currentItem() );
            it.next();
        }
    }
}
