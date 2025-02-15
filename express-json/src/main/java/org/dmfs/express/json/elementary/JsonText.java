package org.dmfs.express.json.elementary;

import org.dmfs.express.json.JsonValue;
import org.dmfs.express.json.Jsonable;
import org.dmfs.express.json.adapters.Json;
import org.dmfs.express.json.sinks.StringBuilderSink;
import org.dmfs.jems2.Single;

import java.io.IOException;
import java.lang.String;


/**
 * JSON text representation of a {@link JsonValue}.
 */
public final class JsonText implements Single<String>
{
    private final JsonValue mJsonValue;


    public JsonText(Jsonable jsonable)
    {
        this(new Json(jsonable));
    }


    public JsonText(JsonValue jsonValue)
    {
        mJsonValue = jsonValue;
    }


    @Override
    public String value()
    {
        StringBuilder sb = new StringBuilder();
        StringBuilderSink sw = new StringBuilderSink(sb);

        try
        {
            mJsonValue.serialize(sw);
        }
        catch (IOException e)
        {
            throw new RuntimeException("IOException while writing to StringBuilder");
        }
        return sb.toString();
    }
}
