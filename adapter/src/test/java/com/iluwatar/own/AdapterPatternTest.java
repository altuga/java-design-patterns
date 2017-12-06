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
package com.iluwatar.own;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Test class
 * 
 */
public class AdapterPatternTest {

  private Map<String, Object> beans;

  private static final String MUHENDIS_BEAN = "muhendis";

  private static final String MUHASEBECI_BEAN = "muhasebe";

  /**
   * This method runs before the test execution and sets the bean objects in the beans Map.
   */
  @Before
  public void setup() {
    beans = new HashMap<>();

    MuhasebeciAdapter muhasebeciAdapter = spy(new MuhasebeciAdapter());
    beans.put(MUHENDIS_BEAN, muhasebeciAdapter);

    BilgisayarMuhendisi bilgisayarMuhendisi = new BilgisayarMuhendisi();
    bilgisayarMuhendisi.setMuhasebeYapabilme((MuhasebeciAdapter) beans.get(MUHENDIS_BEAN));
    beans.put(MUHASEBECI_BEAN, bilgisayarMuhendisi);
  }

  /**
   * This test asserts that when we use the muhasebeIsiYap() method on a bilgisayarMuhasbe bean(client), it is
   * internally calling vergiHesapla method on the fishing boat object. The Adapter ({@link MuhasebeciAdapter}
   * ) converts the interface of the target class ( {@link MuhasebeciAdapter}) into a suitable one
   * expected by the client ({@link BilgisayarMuhendisi} ).
   */
  @Test
  public void testAdapter() {
    BilgisayarMuhendisi bilgisayarMuhendisi = (BilgisayarMuhendisi) beans.get(MUHASEBECI_BEAN);

    // when bilgisayarMuhendisi moves
    bilgisayarMuhendisi.muhasebeIsiYap();

    // the bilgisayarMuhendisi internally calls the battleship object to move
    MuhasebeYapabilme adapter = (MuhasebeYapabilme) beans.get(MUHENDIS_BEAN);
    verify(adapter).muhasebeIsiYap();
  }
}
