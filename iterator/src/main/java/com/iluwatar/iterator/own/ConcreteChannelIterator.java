package com.iluwatar.iterator.own;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//Concrete Iterator //Iterator interface
public class ConcreteChannelIterator implements ChannelIterator{

    private static final Logger LOGGER = LoggerFactory.getLogger(ConcreteChannelIterator.class);
    private List<String> channels;
    private int currentPos = 0;
    public ConcreteChannelIterator(List<String> channels){
        this.channels = channels;
    }

    public boolean hasNext(){
        if(currentPos < channels.size()){
            return true;
        }
        return false;
    }
    public void next(){
        currentPos++;
    }
    public String currentItem(){
        String currentItem = channels.get(currentPos);
        LOGGER.info(currentItem);
        return currentItem;
    }
}
