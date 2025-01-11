package org.dmfs.express.xml.sink;

import org.dmfs.express.xml.XmlSink;


/**
 * An {@link XmlSink} that writes to a {@link StringBuilder}.
 */
public final class StringBuilderSink implements XmlSink
{
    private final StringBuilder mStringBuilder;


    public StringBuilderSink(StringBuilder stringBuilder)
    {
        mStringBuilder = stringBuilder;
    }


    @Override
    public void writeText(String text)
    {
        mStringBuilder.append(text);
    }
}
