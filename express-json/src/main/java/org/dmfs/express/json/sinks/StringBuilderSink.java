package org.dmfs.express.json.sinks;

import org.dmfs.express.json.JsonSink;


/**
 * A {@link JsonSink} writing to a {@link StringBuilder}.
 *
 * @author Marten Gajda
 */
public final class StringBuilderSink implements JsonSink
{
    private final StringBuilder mStringBuilder;


    public StringBuilderSink(StringBuilder stringBuilder)
    {
        mStringBuilder = stringBuilder;
    }


    @Override
    public void writeJson(CharSequence text)
    {
        mStringBuilder.append(text);
    }
}
