/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.factory.method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The Factory Method is a creational design pattern which uses factory methods to deal with the
 * problem of creating objects without specifying the exact class of object that will be created.
 * This is done by creating objects via calling a factory method either specified in an interface
 * and implemented by child classes, or implemented in a base class and optionally overridden by
 * derived classes—rather than by calling a constructor.
 * 
 * <p>Factory produces the object of its liking. 
 * The weapon {@link Vehicle} manufactured by the
 * blacksmith depends on the kind of factory implementation it is referring to.
 * </p>
 */
public class FactoryMethodTest {

  /**
   * Testing {@link FordBlacksmith} to produce a HYBRID asserting that the Vehicle is an instance
   * of {@link FordVehicle}.
   */
  @Test
  public void testFordBlacksmithWithHybrid() {
    // given
    Blacksmith blacksmith = new FordBlacksmith();

    // when
    Vehicle vehicle = blacksmith.manufactureVehicle(VehicleType.HYBRID);

    // then
    verifyVehicle(vehicle, VehicleType.HYBRID, FordVehicle.class);
  }

  /**
   * Testing {@link FordBlacksmith} to produce a SEDAN asserting that the Vehicle is an instance
   *  of {@link FordVehicle}.
   */
  @Test
  public void testFordBlacksmithWithSedan() {
    // given
    Blacksmith blacksmith = new FordBlacksmith();

    // when
    Vehicle vehicle = blacksmith.manufactureVehicle(VehicleType.SEDAN);

    // then
    verifyVehicle(vehicle, VehicleType.SEDAN, FordVehicle.class);
  }

  /**
   * Testing {@link ToyotaBlacksmith} to produce a TRUCK asserting that the Vehicle is an
   * instance of {@link ToyotaVehicle}.
   */
  @Test
  public void testToyotaBlacksmithWithTruck() {
    // given
    Blacksmith blacksmith = new ToyotaBlacksmith();

    // when
    Vehicle vehicle = blacksmith.manufactureVehicle(VehicleType.TRUCK);

    // then
    verifyVehicle(vehicle, VehicleType.TRUCK, ToyotaVehicle.class);
  }

  /**
   * Testing {@link ToyotaBlacksmith} to produce a HYBRID asserting that the Vehicle is an instance
   * of {@link ToyotaVehicle}.
   */
  @Test
  public void testToyotaBlacksmithWithHybrid() {
    // given
    Blacksmith blacksmith = new ToyotaBlacksmith();

    // when
    Vehicle vehicle = blacksmith.manufactureVehicle(VehicleType.HYBRID);

    // then
    verifyVehicle(vehicle, VehicleType.HYBRID, ToyotaVehicle.class);
  }

  /**
   * This method asserts that the vehicle object that is passed is an instance of the clazz and the
   * vehicle is of type expectedVehicleType.
   * 
   * @param vehicle vehicle object which is to be verified
   * @param expectedVehicleType expected VehicleType of the vehicle
   * @param clazz expected class of the vehicle
   */
  private void verifyVehicle(Vehicle vehicle, VehicleType expectedVehicleType, Class<?> clazz) {
    assertTrue("Vehicle must be an object of: " + clazz.getName(), clazz.isInstance(vehicle));
    assertEquals("Vehicle must be of weaponType: " + expectedVehicleType, expectedVehicleType,
        vehicle.getVehicleType());
  }
}
