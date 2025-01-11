package org.dmfs.express.xml;

import org.dmfs.srcless.annotations.composable.Composable;

/**
 * An XML element attribute.
 */
@Composable
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
