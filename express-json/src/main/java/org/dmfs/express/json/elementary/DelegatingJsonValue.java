package org.dmfs.express.json.elementary;

import org.dmfs.express.json.JsonSink;
import org.dmfs.express.json.JsonValue;

import java.io.IOException;
import java.lang.Object;


/**
 * An abstract {@link JsonValue} object which just delegates to another JsonValue object. It's meant to fix the lack of native support for the delegate pattern
 * in Java.
 * <p>
 * You can use it to compose complex {@link JsonValue} {@link Object}s or {@link Array}s and give the result a proper name.
 * <p>
 * Example
 * <pre>{@code
 * public final class Person extends DelegatingJsonValue
 * {
 *     public Person(String firstName, String lastName, int age)
 *     {
 *         super(new Object(
 *             new Member("@class", "person"),
 *             new Member("firstname", firstName),
 *             new Member("lastname", lastName),
 *             new Member("age", age)));
 *     }
 * }
 * }</pre>
 * <p>
 * The following code results in a valid {@link JsonValue} object:
 * <pre>{@code new Person("John", "Doe", 23)}</pre>
 *
 * @deprecated in favour of {@link org.dmfs.express.json.JsonValueComposition}.
 */
@Deprecated
public abstract class DelegatingJsonValue implements JsonValue
{
    private final JsonValue mDelegate;


    public DelegatingJsonValue(JsonValue delegate)
    {
        mDelegate = delegate;
    }


    @Override
    public final void serialize(JsonSink jsonSink) throws IOException
    {
        mDelegate.serialize(jsonSink);
    }
}
