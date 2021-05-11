package org.dmfs.express.xml.xmlelement;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.XmlElement;
import org.dmfs.express.xml.XmlSink;

import java.io.IOException;


/**
 * An abstract {@link XmlElement} which delegates to another one. This is useful to compose elements.
 */
public abstract class CompositeElement implements XmlElement
{
    private final XmlElement mDelegate;


    public CompositeElement(XmlElement delegate)
    {
        mDelegate = delegate;
    }


    @Override
    public final void serialize(
        XmlSink xmlSink,
        NamespaceRegistry namespaceRegistry,
        Iterable<? extends NamespaceBinding> unregisteredPrefixes) throws IOException
    {
        mDelegate.serialize(xmlSink, namespaceRegistry, unregisteredPrefixes);
    }
}
