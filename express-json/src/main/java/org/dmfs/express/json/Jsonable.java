package org.dmfs.express.json;

import org.dmfs.srcless.annotations.composable.Composable;

/**
 * Interface of an object which can render itself to {@link JsonValue}.
 */
@Composable
public interface Jsonable
{
    /**
     * Returns a {@link JsonValue} representation of this object.
     *
     * @return A {@link JsonValue} object, never {@code null}.
     */
    JsonValue toJson();
}
