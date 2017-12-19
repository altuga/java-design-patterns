package com.iluwatar.command;

import com.iluwatar.command.garage.*;
import com.iluwatar.command.helper.InMemoryAppender;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void testCommandPolimorfik() {
        // given
        SimpleRemoteControl remote = new SimpleRemoteControl();
        ArrayList<Command> commandArrayList = new ArrayList<Command>();

        GarageDoor garageDoor = new GarageDoor();
        Light light = new Light();

        // when
        GarageDoorOpenCommand garageOpen =
                new GarageDoorOpenCommand(garageDoor);
        commandArrayList.add(garageOpen);

        LightOnCommand lightOn = new LightOnCommand(light);
        commandArrayList.add(lightOn);

        LightOffCommand lightOffCommand = new LightOffCommand(light);
        commandArrayList.add(lightOffCommand);


        for (Command command: commandArrayList) {
             command.execute();  // power of polimorfizm
        }

        // then
        assertTrue(appender.logContains("Light is on"));
        assertTrue(appender.logContains("Garage Door is Open"));
        assertTrue(appender.logContains("Light is off"));



    }
}
