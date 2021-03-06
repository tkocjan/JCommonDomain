/*
 * Copyright (c) 2014 Red Rainbow IT Solutions GmbH, Germany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.jeecqrs.common.sagas;

import org.jeecqrs.common.commands.Command;

/**
 * Provides the ability to send commands that are dispatched to corresponding
 * handlers.
 */
public interface SagaCommandBus {

    /**
     * Sends a command, which is guaranteed to be delivered if the
     * surrounding transaction commits successfully.
     * 
     * @param <C> the type of the command to send
     * @param command   the command to send
     */
    public <C extends Command<?>> void send(C command);

    /**
     * Sends a command and forgets about it.  If the command handler fails
     * to handle the command, the command gets lost.
     * 
     * @param <C> the type of the command to send
     * @param command   the command to send
     */
    public <C extends Command<?>> void sendAndForget(C command);
    
}
