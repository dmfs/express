package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.QualifiedName;
import org.dmfs.express.xml.Xml;


/**
 * A closing {@link Xml} tag snippet.
 */
public final class ClosingTag extends CompositeXml
{
    public ClosingTag(QualifiedName qualifiedName)
    {
        super(Literals.CLOSING_TAG_OPENING_ANGLE,
            new QualifiedNameXml(qualifiedName),
            Literals.CLOSING_ANGLE);
    }
}
