package org.dmfs.express.json;

/**
 * Interface of an object which can render itself to {@link JsonValue}.
 *
 * @author Marten Gajda
 */
public interface Jsonable
{
    /**
     * Returns a {@link JsonValue} representation of this object.
     *
     * @return A {@link JsonValue} object, never {@code null}.
     */
    JsonValue toJson();
}
