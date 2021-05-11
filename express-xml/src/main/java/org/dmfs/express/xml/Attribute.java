package org.dmfs.express.xml;

/**
 * An XML element attribute.
 */
public interface Attribute
{
    /**
     * The {@link QualifiedName} of the Attribute.
     */
    QualifiedName name();

    /**
     * The {@link String} value of the Attribute.
     */
    String value();
}
