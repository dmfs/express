package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.Xml;
import org.dmfs.express.xml.XmlSink;

import java.io.IOException;

import static org.dmfs.jems2.iterable.EmptyIterable.emptyIterable;


/**
 * An {@link NsCleared} decorator which clears the unregistered namespaces for its children.
 * <p>
 * This should be inserted after the namespaces have been written with {@link NsAttributes}.
 */
public final class NsCleared implements Xml
{
    private final Xml mDelegate;


    public NsCleared(Xml delegate)
    {
        mDelegate = delegate;
    }


    @Override
    public void serialize(
        XmlSink xmlSink,
        NamespaceRegistry namespaceRegistry,
        Iterable<? extends NamespaceBinding> unregisteredPrefixes) throws IOException
    {
        mDelegate.serialize(xmlSink, namespaceRegistry, emptyIterable());
    }
}
