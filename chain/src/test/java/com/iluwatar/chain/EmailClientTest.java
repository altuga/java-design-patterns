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
package com.iluwatar.chain;

import com.iluwatar.chain.helper.InMemoryAppender;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Date: 12/6/17 - 13:29 PM
 *
 * @author Altug Bilgin Altintas
 */
public class EmailClientTest {

  InMemoryAppender appender;

  @Before
  public void setUp() {
    appender = new InMemoryAppender();
  }

  @Test
  public void testMakeRequest() throws Exception {


    // given
    EmailClient emailClient = new EmailClient();

    // when
    emailClient.makeRequest(new Request(RequestType.GMAIL, "Gmail"));
    emailClient.makeRequest(new Request(RequestType.YAHOO, "Yahoo"));
    emailClient.makeRequest(new Request(RequestType.HOTMAIL, "Hotmail"));
    emailClient.makeRequest(new Request(RequestType.YANDEX, "Yandex")); // no handler

    // then
    assertTrue(appender.logContains("Gmail Handler handling request \"Gmail\""));
    assertTrue(appender.logContains("Yahoo Handler handling request \"Yahoo\""));
    assertTrue(appender.logContains("Hotmail Handler handling request \"Hotmail\""));
    assertTrue(appender.logContains("Yandex cannot be handled \"{}\""));






  }

}