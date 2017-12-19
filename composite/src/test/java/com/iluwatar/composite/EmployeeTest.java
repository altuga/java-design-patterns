/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.composite;

import com.iluwatar.composite.own.Coder;
import com.iluwatar.composite.own.Manager;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Date: 12/11/15 - 8:12 PM
 *
 * @author Altug Bilgin Altintas
 */
public class EmployeeTest {



    /**
     * Test
     */
    @Test
    public void testMessageFromElves() {

        // given

        Manager generalManager = new Manager("Osman", 50000);


        Manager manager = new Manager("Nuri", 30000);
        Coder coder1 = new Coder("Ayse", 10000);
        Coder coder2 = new Coder("Fatma", 9000);
        Coder coder3 = new Coder("Zeynep", 9000);

        // when

        manager.add(coder1);
        manager.add(coder2);
        manager.add(coder3);

        generalManager.add(manager);


        // then

        generalManager.print(); // recursion
        assertEquals(108000, generalManager.getTotalSalary(), 0  );



        generalManager.reset();


        manager.print();
        assertEquals(58000, manager.getTotalSalary(), 0  );


    }


}
