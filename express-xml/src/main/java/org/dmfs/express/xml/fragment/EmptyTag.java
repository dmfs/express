package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.Attribute;
import org.dmfs.express.xml.QualifiedName;
import org.dmfs.express.xml.Xml;


/**
 * A composite {@link Xml} rendering to an empty tag.
 */
public final class EmptyTag extends CompositeXml
{
    public EmptyTag(QualifiedName qualifiedName)
    {
        super(Literals.OPENING_TAG_OPENING_ANGLE,
            new QualifiedNameXml(qualifiedName),
            NsAttributes.instance(),
            Literals.EMPTY_TAG_CLOSING_ANGLE);
    }


    public EmptyTag(
        QualifiedName qualifiedName,
        Iterable<? extends Attribute> attributes)
    {
        super(Literals.OPENING_TAG_OPENING_ANGLE,
            new QualifiedNameXml(qualifiedName),
            new AttributesXml(attributes),
            NsAttributes.instance(),
            Literals.EMPTY_TAG_CLOSING_ANGLE);
    }
}
