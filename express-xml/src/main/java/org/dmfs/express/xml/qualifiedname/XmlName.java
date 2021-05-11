package org.dmfs.express.xml.qualifiedname;

import org.dmfs.express.xml.QualifiedName;


/**
 * A {@link QualifiedName} in the {@code xml} namespace.
 */
public final class XmlName extends CompositeQualifiedName
{
    public final static String NAMESPACE = "http://www.w3.org/XML/1998/namespace";


    public XmlName(String name)
    {
        super(NAMESPACE, name);
    }
}
