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

package org.jeecqrs.common;

/**
 * A layer supertype for Identifiable objects.
 */
public abstract class AbstractIdentifiable<T, ID> implements Identifiable<ID>, CompareById<T> {

    @Override
    public final boolean sameIdentityAs(T other) {
        if (other == null || !this.getClass().equals(other.getClass()))
            return false;
        AbstractIdentifiable<T, ID> o = (AbstractIdentifiable<T, ID>) other;
        return this.id().equals(o.id());
    }
 
    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
	if (obj == null || getClass() != obj.getClass())
	    return false;
	final T other = (T) obj;
	return sameIdentityAs(other);
    }
    
    @Override
    public final int hashCode() {
        if (this.id() == null)
            throw new IllegalStateException("Cannot call hashCode() when id() returns null");
        return this.id().hashCode();
    }

}
