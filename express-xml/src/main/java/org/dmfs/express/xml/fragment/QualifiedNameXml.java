package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.*;

import java.io.IOException;


/**
 * The {@link Xml} of a {@link QualifiedName}.
 */
public final class QualifiedNameXml implements Xml
{
    private final QualifiedName mQualifiedName;


    public QualifiedNameXml(QualifiedName qualifiedName)
    {
        mQualifiedName = qualifiedName;
    }


    @Override
    public void serialize(XmlSink xmlSink, NamespaceRegistry namespaceRegistry, Iterable<? extends NamespaceBinding> unregisteredPrefixes) throws IOException
    {
        if (!mQualifiedName.namespace().isEmpty())
        {
            xmlSink.writeText(namespaceRegistry.prefix(mQualifiedName.namespace()).value());
            xmlSink.writeText(":");
        }
        xmlSink.writeText(mQualifiedName.name());
    }
}
