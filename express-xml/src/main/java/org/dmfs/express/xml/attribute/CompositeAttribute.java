package org.dmfs.express.xml.attribute;

import org.dmfs.express.xml.Attribute;
import org.dmfs.express.xml.QualifiedName;


/**
 * An abstract {@link Attribute} delegating to another {@link Attribute}. Useful for composition.
 *
 * @deprecated in favour of {@link org.dmfs.express.xml.AttributeComposition}
 */
@Deprecated
public abstract class CompositeAttribute implements Attribute
{
    private final Attribute mDelegate;


    public CompositeAttribute(Attribute delegate)
    {
        mDelegate = delegate;
    }


    @Override
    public final QualifiedName name()
    {
        return mDelegate.name();
    }


    @Override
    public final String value()
    {
        return mDelegate.value();
    }
}
