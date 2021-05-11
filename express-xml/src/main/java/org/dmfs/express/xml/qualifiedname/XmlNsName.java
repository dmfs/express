package org.dmfs.express.xml.qualifiedname;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.QualifiedName;


/**
 * A {@link QualifiedName} in the {@code xmlns} namespace.
 */
public final class XmlNsName extends CompositeQualifiedName
{
    public static final String NAMESPACE = "http://www.w3.org/2000/xmlns/";


    public XmlNsName(NamespaceBinding namespaceBinding)
    {
        this(namespaceBinding.prefix());
    }


    public XmlNsName(String name)
    {
        super(NAMESPACE, name);
    }
}
