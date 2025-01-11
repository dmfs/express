package org.dmfs.express.xml.attribute;

import org.dmfs.express.xml.Attribute;
import org.dmfs.express.xml.AttributeComposition;
import org.dmfs.express.xml.qualifiedname.XmlName;


/**
 * An {@link Attribute} in the {@code xml} namespace.
 */
public final class XmlAttr extends AttributeComposition
{
    public XmlAttr(String prefix, String value)
    {
        super(new Attr(new XmlName(prefix), value));
    }
}
