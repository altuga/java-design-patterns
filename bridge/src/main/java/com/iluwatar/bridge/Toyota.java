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
package com.iluwatar.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Toyota
 *
 */
public class Toyota implements Vehicle {

  private static final Logger LOGGER = LoggerFactory.getLogger(Toyota.class);

  private final GearBox gearBox;

  public Toyota(GearBox gearBox) {
    this.gearBox = gearBox;
  }

  @Override
  public void startEngine() {
    LOGGER.info("Toyota is ready to go");
    gearBox.onActivate();
  }

  @Override
  public void drive() {
    LOGGER.info("Toyota is great ...");
    gearBox.apply();
  }

  @Override
  public void stopEngine() {
    LOGGER.info("We arrived , stop Toyota");
    gearBox.onDeactivate();
  }

  @Override
  public GearBox getGearBox() {
    return gearBox;
  }
}
