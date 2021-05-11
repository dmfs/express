package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.Attribute;
import org.dmfs.express.xml.Xml;
import org.dmfs.jems2.iterable.Mapped;


/**
 * An {@link Xml} snippet of an {@link Iterable} of attributes.
 */
public final class AttributesXml extends CompositeXml
{
    public AttributesXml(Iterable<? extends Attribute> attributes)
    {
        super(new Mapped<>(
            AttributeXml::new,
            attributes));
    }
}
