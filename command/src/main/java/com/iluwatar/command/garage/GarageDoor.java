package com.iluwatar.command.garage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GarageDoor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GarageDoor.class);

    public GarageDoor() {
    }

    public void up() {
        LOGGER.info("Garage Door is Open");
    }

    public void down() {
        LOGGER.info("Garage Door is Closed");
    }

    public void stop() {
        LOGGER.info("Garage Door is Stopped");
    }

    public void lightOn() {
        LOGGER.info("Garage light is on");
    }

    public void lightOff() {
        LOGGER.info("Garage light is off");
    }
}