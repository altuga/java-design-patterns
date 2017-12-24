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
package com.iluwatar.templatemethod;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Date: 12/29/15 - 18:15 PM
 *
 * @author @altugaltintas
 */
public class EngineerTest {

  /**
   * Verify if the engineer uses the provided engineering method
   */
  @Test
  public void testDoIt() {

    // Given
    final EngineeringMethod method = mock(EngineeringMethod.class);
    final Engineer engineer = new Engineer(method);

    // When
    engineer.justDoIt();

    // Then
    verify(method).doIt();
    verifyNoMoreInteractions(method);
  }

  /**
   * Verify if the engineer uses the provided doIT method, and the new method after changing it
   */
  @Test
  public void testChangeMethod() {

    // Given
    final EngineeringMethod initialMethod = mock(EngineeringMethod.class);
    final Engineer engineer = new Engineer(initialMethod);

    // When
    engineer.justDoIt();

    // Then
    verify(initialMethod).doIt();

    // Given
    final EngineeringMethod newMethod = mock(EngineeringMethod.class);

    // When
    engineer.changeMethod(newMethod);
    engineer.justDoIt();

    // Then
    verify(newMethod).doIt();
    verifyNoMoreInteractions(initialMethod, newMethod);

  }
}