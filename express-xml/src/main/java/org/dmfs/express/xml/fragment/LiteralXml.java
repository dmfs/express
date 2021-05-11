package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.Xml;
import org.dmfs.express.xml.XmlSink;

import java.io.IOException;


/**
 * Literal {@link Xml}. This is meant for internal use. The given XML literal is <em>not</em> validated!
 */
public final class LiteralXml implements Xml
{
    private final String mLiteral;


    public LiteralXml(String literal)
    {
        mLiteral = literal;
    }


    @Override
    public void serialize(
        XmlSink xmlSink,
        NamespaceRegistry namespaceRegistry,
        Iterable<? extends NamespaceBinding> unregisteredPrefixes) throws IOException
    {
        xmlSink.writeText(mLiteral);
    }
}
