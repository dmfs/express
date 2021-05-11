package org.dmfs.express.xml;

/**
 * A qualified name.
 */
public interface QualifiedName
{
    /**
     * The namespace of the qualified name or an empty String for the default namespace.
     * <p>
     * Note, XML doesn't allow empty namespaces. However, in this implementation an empty namespace refers to the default namespace.
     */
    String namespace();

    /**
     * The name of the qualified name.
     */
    String name();
}
