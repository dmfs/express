package org.dmfs.express.json.adapters;

import org.dmfs.express.json.JsonSink;
import org.dmfs.express.json.JsonValue;
import org.dmfs.express.json.Jsonable;

import java.io.IOException;


/**
 * The {@link JsonValue} of a {@link Jsonable} object.
 */
public final class Json implements JsonValue
{
    private final Jsonable mJsonable;


    public Json(Jsonable jsonable)
    {
        mJsonable = jsonable;
    }


    @Override
    public void serialize(JsonSink jsonSink) throws IOException
    {
        mJsonable.toJson().serialize(jsonSink);
    }
}
