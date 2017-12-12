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
package com.iluwatar.strategy;

import com.iluwatar.strategy.own.ITUzmani;
import com.iluwatar.strategy.own.ITUzmaniAyse;
import com.iluwatar.strategy.own.KodYazabilme;
import com.iluwatar.strategy.own.KodcuSenior;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Date: 12/29/17 - 10:50 PM
 *
 * @author Altug Bilgin Altintas
 */
public class KodcuTest {

  /**
   * Verify if the kodcu uses the strategy during coding
   */
  @Test
  public void testKodYazabilme() {
    final KodYazabilme strategy = mock(KodcuSenior.class);
    final ITUzmani itUzmani = new ITUzmaniAyse();
    itUzmani.setKodYazabilme(strategy);

    itUzmani.kodlayabilirMisin();
    verify(strategy).kodla();
    verifyNoMoreInteractions(strategy);
  }

  @Test
  public void testTestEdebilme() {
   //...

  }



}