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
package com.iluwatar.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Command pattern is a behavioral design pattern in which an object is used to encapsulate all
 * information needed to perform an action or trigger an event at a later time. This information
 * includes the method name, the object that owns the method and values for the method parameters.
 * 
 * <p>Four terms always associated with the command pattern are command, receiver, invoker and 
 * client. A command object (spell) knows about the receiver (target) and invokes a method of 
 * the receiver.Values for parameters of the receiver method are stored in the command. The receiver
 * then does the work. An invoker object (wizard) knows how to execute a command, and optionally 
 * does bookkeeping about the command execution. The invoker does not know anything about a 
 * concrete command, it knows only about command interface. Both an invoker object and several 
 * command objects are held by a client object (app). The client decides which commands to execute
 * at which points. To execute a command, it passes the command object to the invoker object.
 */
public class CommandTest {

  private static final String WEB_PAGE = "WebPage";


  @Test
  public void testCommand() {

    // given
    User user = new User();
    WebPage webPage = new WebPage();

    // when
    user.action(new MakeItSmallDesign(), webPage);

    // then
    verifyWebpage(webPage, WEB_PAGE, Size.SMALL, Mobility.MOBILE);

    // ...........................................................

    // when
    user.action(new DesktopDesign(), webPage);

    // then
    verifyWebpage(webPage, WEB_PAGE, Size.SMALL, Mobility.MOBILE_DISABLED);

    // ...........................................................

    // when
    user.undoLastAction();

    // then
    verifyWebpage(webPage, WEB_PAGE, Size.SMALL, Mobility.MOBILE);

    // ...........................................................

    // when
    user.undoLastAction();

    // then
    verifyWebpage(webPage, WEB_PAGE, Size.NORMAL, Mobility.MOBILE);

    // ...........................................................

    // when
    user.redoLastAction();

    // then
    verifyWebpage(webPage, WEB_PAGE, Size.SMALL, Mobility.MOBILE);

    // ...........................................................

    // when
    user.redoLastAction();

    // then
    verifyWebpage(webPage, WEB_PAGE, Size.SMALL, Mobility.MOBILE_DISABLED);
  }

  /**
   * This method asserts that the passed webPage object has the name as expectedName, size as
   * expectedSize and visibility as expectedVisibility.
   *
   * @param webPage a webPage object whose state is to be verified against other parameters
   * @param expectedName expectedName of the webPage
   * @param expectedSize expected size of the webPage
   * @param expectedVisibilty exepcted visibility of the webPage
   */
  private void verifyWebpage(WebPage webPage, String expectedName, Size expectedSize,
                             Mobility expectedVisibilty) {
    assertEquals("WebPage's name must be same as expectedName", expectedName, webPage.toString());
    assertEquals("WebPage's size must be same as expectedSize", expectedSize, webPage.getSize());
    assertEquals("WebPage's visibility must be same as expectedVisibility", expectedVisibilty,
        webPage.getMobility());
  }
}
