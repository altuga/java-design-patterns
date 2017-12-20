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
package com.iluwatar.iterator;

import com.iluwatar.iterator.own.ChannelIterator;
import com.iluwatar.iterator.own.ConcreteTV;
import helper.InMemoryAppender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Date: 12/14/17 - 2:58 PM
 *
 * @author Altug Altintas
 */

public class TvTest {

  InMemoryAppender appender;

  @Before
  public void setup() {
    appender = new InMemoryAppender();

  }
  /**
   * Test if the expected item can be retrieved from the channels.
   */
  @Test
  public void testIterator() {

    // Given
    List<String> channells = new ArrayList<String>();
    channells.add("A kanali");
    channells.add("B kanali");
    channells.add("C kanali");

    ConcreteTV concreteTV = new ConcreteTV(channells);
    assertNotNull(concreteTV);

    // When
    ChannelIterator concreteTVIterator = concreteTV.getIterator();
    while(concreteTVIterator.hasNext()){
      assertNotNull(concreteTVIterator.currentItem());
      concreteTVIterator.next();
    }


    // Then
    assertTrue(appender.logContains("A kanali"));
    assertTrue(appender.logContains("B kanali"));
    assertTrue(appender.logContains("C kanali"));

  }



}