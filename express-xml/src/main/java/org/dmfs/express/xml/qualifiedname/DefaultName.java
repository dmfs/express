package org.dmfs.express.xml.qualifiedname;

import org.dmfs.express.xml.QualifiedName;


/**
 * A {@link QualifiedName} in the default namespace.
 * <p>
 * Note, this implementation uses the empty string as the default namespace.
 */
public final class DefaultName extends CompositeQualifiedName
{
    public DefaultName(String name)
    {
        super("", name);
    }
}
