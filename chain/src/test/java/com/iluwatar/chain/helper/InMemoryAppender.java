package com.iluwatar.chain.helper;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class InMemoryAppender extends AppenderBase<ILoggingEvent> {

    private List<ILoggingEvent> log = new LinkedList<>();

    public InMemoryAppender() {
        ((Logger) LoggerFactory.getLogger("root")).addAppender(this);
        start();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
        log.add(eventObject);
    }

    public int getLogSize() {
        return log.size();
    }

    public boolean logContains(String message) {
        return log.stream().anyMatch(event -> event.getFormattedMessage().equals(message));
    }
}