/*
 * File: ApplicationListener.java
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

package com.oracle.tools.runtime;

/**
 * A listener for {@link Application} life-cycle events.
 *
 * @author Brian Oliver
 *
 * @param <A>  the type of the {@link Application} in the {@link Assembly}
 */
public interface ApplicationListener<A extends Application>
{
    /**
     * Called prior to an {@link Application} being closed.
     *
     * @param application  the {@link Application} being closed
     */
    public void onClosing(A application);


    /**
     * Called after an {@link Application} was closed.
     *
     * @param application  the {@link Application} that was closed
     */
    public void onClosed(A application);


    /**
     * Called after an {@link Application} has been realized.
     *
     * @param application  the {@link Application} the was realized
     */
    public void onRealized(A application);
}
