package org.dmfs.express.xml.qualifiedname;

import org.dmfs.express.xml.QualifiedName;


/**
 * A {@link QualifiedName} for easy composition.
 */
public abstract class CompositeQualifiedName implements QualifiedName
{
    private final QualifiedName mDelegate;


    protected CompositeQualifiedName(String namespace, String name)
    {
        this(new Qn(namespace, name));
    }


    protected CompositeQualifiedName(QualifiedName delegate)
    {
        mDelegate = delegate;
    }


    @Override
    public final String namespace()
    {
        return mDelegate.namespace();
    }


    @Override
    public final String name()
    {
        return mDelegate.name();
    }
}
