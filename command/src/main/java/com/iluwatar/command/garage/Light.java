package com.iluwatar.command.garage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Light {

    private static final Logger LOGGER = LoggerFactory.getLogger(Light.class);
    public Light() {
    }

    public void on() {
        LOGGER.info("Light is on");
    }

    public void off() {
        LOGGER.info("Light is off");
    }
}
