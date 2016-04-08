/*
 * File: TestsTest.java
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * The contents of this file are subject to the terms and conditions of
 * the Common Development and Distribution License 1.0 (the "License").
 *
 * You may not use this file except in compliance with the License.
 *
 * You can obtain a copy of the License by consulting the LICENSE.txt file
 * distributed with this file, or by consulting https://oss.oracle.com/licenses/CDDL
 *
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file LICENSE.txt.
 *
 * MODIFICATIONS:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 */

package com.oracle.tools.junit.options;

import com.oracle.tools.Options;
import com.oracle.tools.junit.MyOtherTest;
import com.oracle.tools.junit.JUnit4Test;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link Tests} class.
 * <p>
 * Copyright (c) 2016. All Rights Reserved. Oracle Corporation.<br>
 * Oracle is a registered trademark of Oracle Corporation and/or its affiliates.
 *
 * @author Jonathan Knight
 */
public class TestsTest
{
    @Test
    public void shouldWorkAsAnOption() throws Exception
    {
        TestClasses tests   = TestClasses.of(JUnit4Test.class);
        Options     options = new Options(tests);
        Tests       result  = options.get(Tests.class);

        assertThat(result, is(notNullValue()));
        assertThat(result, contains(tests));
    }


    @Test
    public void shouldHaveEmptyTestsAsDefaultOption() throws Exception
    {
        Options options = new Options();
        Tests   result  = options.get(Tests.class);

        assertThat(result, is(notNullValue()));
        assertThat(result.iterator().hasNext(), is(false));
    }

    @Test
    public void shouldAddMultipleSpecifiedTestClasses() throws Exception
    {
        TestClasses first   = TestClasses.of(JUnit4Test.class);
        TestClasses second  = TestClasses.of(MyOtherTest.class);
        Options     options = new Options(first, second);
        Tests       result  = options.get(Tests.class);

        assertThat(result, is(notNullValue()));
        assertThat(result, contains(first, second));
    }


    @Test
    public void shouldRemoveSpecificTestClass() throws Exception
    {
        TestClasses first   = TestClasses.of(JUnit4Test.class);
        TestClasses second  = TestClasses.of(MyOtherTest.class);
        Options     options = new Options(first, second);

        options.remove(TestClasses.of(JUnit4Test.class));

        Tests result = options.get(Tests.class);

        assertThat(result, is(notNullValue()));
        assertThat(result, contains(second));
    }


}
