package org.dmfs.express.xml.xmlcontent;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.XmlContent;
import org.dmfs.express.xml.XmlSink;
import org.dmfs.jems2.iterable.Seq;

import java.io.IOException;


/**
 * {@link XmlContent} composed of other {@link XmlContent}.
 */
public final class Composite implements XmlContent
{
    private final Iterable<? extends XmlContent> mParts;


    public Composite(XmlContent... parts)
    {
        this(new Seq<>(parts));
    }


    public Composite(Iterable<? extends XmlContent> parts)
    {
        mParts = parts;
    }


    @Override
    public void serialize(
        XmlSink xmlSink,
        NamespaceRegistry namespaceRegistry,
        Iterable<? extends NamespaceBinding> unregisteredPrefixes) throws IOException
    {
        for (XmlContent xmlSerializable : mParts)
        {
            xmlSerializable.serialize(xmlSink, namespaceRegistry, unregisteredPrefixes);
        }
    }
}
