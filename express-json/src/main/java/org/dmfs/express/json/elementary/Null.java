package org.dmfs.express.json.elementary;

import org.dmfs.express.json.JsonSink;
import org.dmfs.express.json.JsonValue;

import java.io.IOException;


/**
 * The trivial {@link JsonValue} {@code null} value.
 *
 * @author Marten Gajda
 */
public final class Null implements JsonValue
{
    public final static JsonValue NULL = new Null();


    @Override
    public void serialize(JsonSink jsonSink) throws IOException
    {
        jsonSink.writeJson("null");
    }
}
