package org.dmfs.express.xml.sink;

import org.dmfs.express.xml.XmlSink;

import java.io.IOException;
import java.io.Writer;


/**
 * An {@link XmlSink} that writes to a {@link Writer}
 */
public final class WriterSink implements XmlSink
{
    private final Writer mWriter;


    public WriterSink(Writer writer)
    {
        mWriter = writer;
    }


    @Override
    public XmlSink writeText(String text) throws IOException
    {
        mWriter.write(text);
        return this;
    }
}
