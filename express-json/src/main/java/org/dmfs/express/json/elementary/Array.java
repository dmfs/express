package org.dmfs.express.json.elementary;

import org.dmfs.express.json.JsonSink;
import org.dmfs.express.json.JsonValue;
import org.dmfs.express.json.Jsonable;
import org.dmfs.express.json.adapters.Json;
import org.dmfs.iterables.elementary.Seq;
import org.dmfs.jems.iterable.decorators.Mapped;

import java.io.IOException;


/**
 * A {@link JsonValue} array. A JSON array can contain any JSON value.
 *
 * @author Marten Gajda
 */
public final class Array implements JsonValue
{
    private final Iterable<JsonValue> mElements;


    /**
     * Creates a {@link JsonValue} array of {@link Jsonable}s.
     *
     * @param elements
     *         the elements of the Array
     */
    public Array(Jsonable... elements)
    {
        this(new Mapped<>(Json::new, new Seq<>(elements)));
    }


    /**
     * Creates a {@link JsonValue} array of {@link Boolean}s.
     *
     * @param elements
     *         the elements of the Array
     */
    public Array(java.lang.Boolean... elements)
    {
        this(new Mapped<>(Boolean::new, new Seq<>(elements)));
    }


    /**
     * Creates a {@link JsonValue} array of {@link Number}s.
     *
     * @param elements
     *         the elements of the Array
     */
    public Array(java.lang.Number... elements)
    {
        this(new Mapped<>(Number::new, new Seq<>(elements)));
    }


    /**
     * Creates a {@link JsonValue} array of {@link CharSequence}s.
     *
     * @param elements
     *         the elements of the Array
     */
    public Array(CharSequence... elements)
    {
        this(new Mapped<>(String::new, new Seq<>(elements)));
    }


    /**
     * Creates a {@link JsonValue} array of arbitrary {@link JsonValue} values.
     *
     * @param elements
     *         the elements of the Array
     */
    public Array(JsonValue... elements)
    {
        this(new Seq<>(elements));
    }


    /**
     * Creates a {@link JsonValue} array of arbitrary {@link JsonValue} values.
     *
     * @param elements
     *         An {@link Iterable} of {@link JsonValue} values.
     */
    public Array(Iterable<JsonValue> elements)
    {
        mElements = elements;
    }


    @Override
    public void serialize(JsonSink jsonSink) throws IOException
    {
        jsonSink.writeJson("[");
        boolean first = true;
        for (JsonValue element : mElements)
        {
            if (first)
            {
                first = false;
            }
            else
            {
                jsonSink.writeJson(",");
            }
            element.serialize(jsonSink);
        }
        jsonSink.writeJson("]");
    }
}
