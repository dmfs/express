package org.dmfs.express.xml.attribute;

import org.dmfs.express.xml.Attribute;
import org.dmfs.express.xml.AttributeComposition;
import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.qualifiedname.XmlNsName;


/**
 * An {@link Attribute} binding a namespace to a prefix.
 */
public final class XmlNsAttr extends AttributeComposition
{
    public XmlNsAttr(NamespaceBinding namespaceBinding)
    {
        super(new Attr(new XmlNsName(namespaceBinding), namespaceBinding::namespace));
    }
}
