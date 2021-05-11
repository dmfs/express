package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.Xml;
import org.dmfs.express.xml.XmlSink;
import org.dmfs.jems2.iterable.Seq;

import java.io.IOException;


/**
 * An abstract base class for composing complex XML fragments.
 */
public abstract class CompositeXml implements Xml
{
    private final Iterable<? extends Xml> mParts;


    public CompositeXml(Xml... parts)
    {
        this(new Seq<>(parts));
    }


    public CompositeXml(Iterable<? extends Xml> parts)
    {
        mParts = parts;
    }


    @Override
    public final void serialize(
        XmlSink xmlSink,
        NamespaceRegistry namespaceRegistry,
        Iterable<? extends NamespaceBinding> unregisteredPrefixes) throws IOException
    {
        for (Xml xmlSerializable : mParts)
        {
            xmlSerializable.serialize(xmlSink, namespaceRegistry, unregisteredPrefixes);
        }
    }
}
