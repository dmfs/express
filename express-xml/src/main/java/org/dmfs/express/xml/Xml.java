package org.dmfs.express.xml;

import java.io.IOException;


/**
 * A raw XML snippet.
 */
public interface Xml
{
    /**
     * Serializes the XML to the given {@link XmlSink}.
     */
    void serialize(XmlSink xmlSink, NamespaceRegistry namespaceRegistry, Iterable<? extends NamespaceBinding> unregisteredPrefixes) throws IOException;
}