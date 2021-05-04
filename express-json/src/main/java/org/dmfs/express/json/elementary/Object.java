package org.dmfs.express.json.elementary;

import org.dmfs.express.json.JsonSink;
import org.dmfs.express.json.JsonValue;
import org.dmfs.express.json.decorators.Nullable;
import org.dmfs.jems2.Pair;
import org.dmfs.jems2.iterable.Seq;

import java.io.IOException;


/**
 * A {@link JsonValue} object. A JSON object has a number of members, each one identified by a key and having a value (which may be {@link Null} or {@link
 * Nullable}, but not {@code null}).
 * <p>
 * Members are passed as {@link Pair}s of keys and values with keys being {@link String}s and values being {@link JsonValue}.
 *
 * @author Marten Gajda
 */
public final class Object implements JsonValue
{
    private final Iterable<Pair<String, JsonValue>> mElements;


    @SafeVarargs
    public Object(Pair<String, JsonValue>... elements)
    {
        this(new Seq<>(elements));
    }


    public Object(Iterable<Pair<String, JsonValue>> elements)
    {
        mElements = elements;
    }


    @Override
    public void serialize(JsonSink jsonSink) throws IOException
    {
        jsonSink.writeJson("{");
        boolean first = true;
        for (Pair<String, JsonValue> element : mElements)
        {
            if (first)
            {
                first = false;
            }
            else
            {
                jsonSink.writeJson(",");
            }
            element.left().serialize(jsonSink);
            jsonSink.writeJson(":");
            element.right().serialize(jsonSink);
        }
        jsonSink.writeJson("}");
    }
}
