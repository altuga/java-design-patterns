package com.iluwatar.iterator.own;

import java.util.List;

//Concrete Aggregator
public class ConcreteTV implements TV {

    ChannelIterator iterator;


    public ConcreteTV(List<String> channels){
        iterator = new ConcreteChannelIterator(channels);
    }
    public ChannelIterator getIterator(){
        return iterator;
    }


}
