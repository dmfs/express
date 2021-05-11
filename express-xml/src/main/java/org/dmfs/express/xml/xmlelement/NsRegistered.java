package org.dmfs.express.xml.xmlelement;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.XmlElement;
import org.dmfs.express.xml.XmlSink;
import org.dmfs.jems2.Pair;
import org.dmfs.jems2.iterable.Joined;

import java.io.IOException;


/**
 * An {@link XmlElement} decorator which ensures there is a namespace prefix mapping for a list of given namespaces.
 * <p>
 * Namespaces for which no mapping exists, are mapped and appended to the {@code unregisteredPrefixes}. A child node must ensure the new prefixes are declared.
 */
final class NsRegistered implements XmlElement
{
    private final Iterable<String> mNamespaces;
    private final XmlElement mDelegate;


    public NsRegistered(Iterable<String> namespaces, XmlElement delegate)
    {
        mNamespaces = namespaces;
        mDelegate = delegate;
    }


    @Override
    public void serialize(
        XmlSink xmlSink,
        NamespaceRegistry namespaceRegistry,
        Iterable<? extends NamespaceBinding> unregisteredPrefixes) throws IOException
    {
        Pair<NamespaceRegistry, Iterable<NamespaceBinding>> result = namespaceRegistry.withNamespaces(mNamespaces);
        mDelegate.serialize(xmlSink, result.left(), new Joined<>(result.right(), unregisteredPrefixes));
    }
}
