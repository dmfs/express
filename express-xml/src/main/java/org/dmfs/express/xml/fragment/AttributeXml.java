package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.Attribute;
import org.dmfs.express.xml.Xml;
import org.dmfs.express.xml.xmlcontent.Text;


/**
 * The {@link Xml} snippet of an XML attribute.
 */
public final class AttributeXml extends CompositeXml
{
    public AttributeXml(Attribute attribute)
    {
        super(Literals.WHITE_SPACE,
            new QualifiedNameXml(attribute.name()),
            Literals.EQUALS,
            Literals.QUOTES,
            new Text(attribute::value),
            Literals.QUOTES);
    }
}
