package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.Xml;
import org.dmfs.express.xml.XmlSink;
import org.dmfs.express.xml.attribute.XmlNsAttr;
import org.dmfs.jems2.iterable.Mapped;

import java.io.IOException;

import static org.dmfs.jems2.iterable.EmptyIterable.emptyIterable;


/**
 * An {@link NsAttributes} which renders the namespace attributes of all currently unregistered namespaces.
 */
public final class NsAttributes implements Xml
{
    private static final NsAttributes INSTANCE = new NsAttributes();


    public static NsAttributes instance()
    {
        return INSTANCE;
    }


    @Override
    public void serialize(
        XmlSink xmlSink,
        NamespaceRegistry namespaceRegistry,
        Iterable<? extends NamespaceBinding> unregisteredPrefixes) throws IOException
    {
        new AttributesXml(new Mapped<>(XmlNsAttr::new, unregisteredPrefixes))
            .serialize(xmlSink, namespaceRegistry, emptyIterable());
    }
}
