package org.dmfs.express.xml.utils;

import org.dmfs.express.xml.XmlElement;
import org.dmfs.express.xml.namespaceregistry.DefaultNamespaceRegistry;
import org.dmfs.express.xml.sink.StringBuilderSink;
import org.dmfs.jems2.Single;

import java.io.IOException;

import static org.dmfs.jems2.iterable.EmptyIterable.emptyIterable;


/**
 * A {@link Single} of the {@link String} representation of an {@link XmlElement}.
 */
public final class XmlString implements Single<String>
{
    private final XmlElement mXml;


    public XmlString(XmlElement xml)
    {
        mXml = xml;
    }


    @Override
    public String value()
    {
        StringBuilder sb = new StringBuilder();
        StringBuilderSink sw = new StringBuilderSink(sb);

        try
        {
            mXml.serialize(sw, new DefaultNamespaceRegistry(), emptyIterable());
        }
        catch (IOException e)
        {
            throw new RuntimeException();
        }
        return sb.toString();
    }
}
