package org.dmfs.express.xml.utils;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Conditional;
import org.dmfs.jems2.optional.DelegatingOptional;


/**
 * An {@link Optional} of an {@link Iterable} that's absent if the {@link Iterable} as no elements.
 */
// TODO: move to jems
public final class NonEmpty<T> extends DelegatingOptional<Iterable<T>>
{
    public NonEmpty(Iterable<T> delegate)
    {
        super(new Conditional<>(value -> value.iterator().hasNext(), delegate));
    }
}
