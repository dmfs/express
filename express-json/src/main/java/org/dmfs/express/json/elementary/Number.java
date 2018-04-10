package org.dmfs.express.json.elementary;

import org.dmfs.express.json.JsonSink;
import org.dmfs.express.json.JsonValue;

import java.io.IOException;


/**
 * A number {@link JsonValue}.
 *
 * @author Marten Gajda
 */
public final class Number implements JsonValue
{
    private final java.lang.Number mNumber;


    public Number(java.lang.Number number)
    {
        mNumber = number;
    }


    @Override
    public void serialize(JsonSink jsonSink) throws IOException
    {
        jsonSink.writeJson(mNumber.toString());
    }
}
