package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.Attribute;
import org.dmfs.express.xml.QualifiedName;
import org.dmfs.express.xml.Xml;


/**
 * An opening {@link Xml} tag.
 */
public final class OpeningTag extends CompositeXml
{
    public OpeningTag(QualifiedName qualifiedName)
    {
        super(Literals.OPENING_TAG_OPENING_ANGLE,
            new QualifiedNameXml(qualifiedName),
            NsAttributes.instance(),
            Literals.CLOSING_ANGLE);
    }


    public OpeningTag(QualifiedName qualifiedName, Iterable<? extends Attribute> attributes)
    {
        super(Literals.OPENING_TAG_OPENING_ANGLE,
            new QualifiedNameXml(qualifiedName),
            new AttributesXml(attributes),
            NsAttributes.instance(),
            Literals.CLOSING_ANGLE);
    }
}
