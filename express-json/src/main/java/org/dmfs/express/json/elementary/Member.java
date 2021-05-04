package org.dmfs.express.json.elementary;

import org.dmfs.express.json.JsonValue;
import org.dmfs.express.json.Jsonable;
import org.dmfs.express.json.adapters.Json;
import org.dmfs.jems2.Pair;

import java.lang.Object;


/**
 * A {@link JsonValue} {@link Object} member.
 * <p>
 * It provides convenience constructors to declare members more concisely.
 * <p>
 * Example:
 * <pre>{@code
 * new Object(
 *     new Member("name", "John Doe"),
 *     new Member("age", 42),
 *     new Member("hobbies", new Array("Golf", "Games"));
 * }</pre>
 *
 * @author Marten Gajda
 */
public final class Member implements Pair<String, JsonValue>
{
    private final String mKey;
    private final JsonValue mValue;


    public Member(CharSequence key, Jsonable value)
    {
        this(key, new Json(value));
    }


    public Member(CharSequence key, java.lang.Boolean value)
    {
        this(key, new Boolean(value));
    }


    public Member(CharSequence key, CharSequence value)
    {
        this(key, new String(value));
    }


    public Member(CharSequence key, java.lang.Number value)
    {
        this(key, new Number(value));
    }


    public Member(CharSequence key, JsonValue value)
    {
        this(new String(key), value);
    }


    public Member(String key, JsonValue value)
    {
        mKey = key;
        mValue = value;
    }


    @Override
    public String left()
    {
        return mKey;
    }


    @Override
    public JsonValue right()
    {
        return mValue;
    }
}
