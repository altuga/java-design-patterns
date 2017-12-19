package com.iluwatar.command;

import com.iluwatar.command.garage.*;
import com.iluwatar.command.helper.InMemoryAppender;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SimpleRemoteControlTest {

    InMemoryAppender appender;

    @Before
    public void setUp() {
        appender = new InMemoryAppender();
    }


    @Test
    public void testCommand() {

        // given
        SimpleRemoteControl remote = new SimpleRemoteControl();

        GarageDoor garageDoor = new GarageDoor();
        Light light = new Light();

        // when
        GarageDoorOpenCommand garageOpen =
                new GarageDoorOpenCommand(garageDoor);
        LightOnCommand lightOn = new LightOnCommand(light);


        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(garageOpen);
        remote.buttonWasPressed();

        // then
        assertTrue(appender.logContains("Light is on"));
        assertTrue(appender.logContains("Garage Door is Open"));
    }
}
