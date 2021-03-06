/*
 * Copyright (c) 2013 Red Rainbow IT Solutions GmbH, Germany
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

package org.jeecqrs.common.event;

import java.util.Date;
import org.jeecqrs.common.AbstractIdentifiable;
import org.jeecqrs.common.Identity;

/**
 * Layer supertype for events.
 */
public abstract class AbstractEvent<T> extends AbstractIdentifiable<T, Identity>
	implements Event<T> {

    private DefaultEventId id;
    private Date occurredOn;

    public AbstractEvent() {
        this(new Date());
    }

    public AbstractEvent(String idString, Date occurredOn) {
        this(new DefaultEventId(), occurredOn);
    }

    public AbstractEvent(Date occurredOn) {
        this(new DefaultEventId(), occurredOn);
    }

    public AbstractEvent(DefaultEventId id, Date occurredOn) {
        this.id = id;
        this.occurredOn = new Date(occurredOn.getTime());
    }

    @Override
    public Identity id() {
        return this.id;
    }

    @Override
    public Date occurredOn() {
        return new Date(this.occurredOn.getTime());
    }
    
}
