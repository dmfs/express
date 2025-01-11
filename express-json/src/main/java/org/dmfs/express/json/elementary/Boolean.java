package org.dmfs.express.json.elementary;

import org.dmfs.express.json.JsonSink;
import org.dmfs.express.json.JsonValue;

import java.io.IOException;


/**
 * A trivial {@link JsonValue} value which can be either {@code true} or {@code false}.
 */
public final class Boolean implements JsonValue
{
    public final static Boolean TRUE = new Boolean(true);
    public final static Boolean FALSE = new Boolean(false);

    private final java.lang.Boolean mBoolean;


    public Boolean(java.lang.Boolean bool)
    {
        mBoolean = bool;
    }


    @Override
    public void serialize(JsonSink jsonSink) throws IOException
    {
        jsonSink.writeJson(mBoolean.toString());
    }
}
