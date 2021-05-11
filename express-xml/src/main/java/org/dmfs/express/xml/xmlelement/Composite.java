package org.dmfs.express.xml.xmlelement;

import org.dmfs.express.xml.*;
import org.dmfs.jems2.Single;
import org.dmfs.jems2.iterable.Seq;

import java.io.IOException;


/**
 * An {@link XmlElement} composed from various {@link Xml} snippets.
 */
final class Composite implements XmlElement
{
    private final Iterable<? extends Xml> mParts;


    public Composite(Xml... parts)
    {
        this(new Seq<>(parts));
    }


    public Composite(Single<? extends Iterable<Xml>> parts)
    {
        this(() -> parts.value().iterator());
    }


    public Composite(Iterable<? extends Xml> parts)
    {
        mParts = parts;
    }


    @Override
    public void serialize(
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
