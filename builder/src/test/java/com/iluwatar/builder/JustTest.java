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
package com.iluwatar.builder;

import com.iluwatar.builder.own.NutritionFacts;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 *
 * @author Altug Altintas
 */
public class JustTest {



  /**
   * Test if we get the expected exception when trying to create a NutritionFacts without a servingSize
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMissingName() throws Exception {
    NutritionFacts cocaCola = new NutritionFacts.Builder(0 , 8).build();
  }

  /**
   * Test if the hero build by the builder has the correct attributes, as requested
   */
  @Test
  public void testBuildHero() throws Exception {


    NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
            .calories(100).sodium(35).carbohydrate(27).build();

    assertNotNull(cocaCola);
    assertEquals(cocaCola.getServingSize(), 240);
    assertEquals(cocaCola.getServings(), 8);
    assertEquals(cocaCola.getCalories(), 100);
    assertEquals(cocaCola.getSodium(), 35);
    assertEquals(cocaCola.getCarbohydrate(), 27);


  }

}