package org.dmfs.express.json;

import org.dmfs.srcless.annotations.composable.Composable;

import java.io.IOException;


/**
 * A JSON value as per <a href="https://tools.ietf.org/html/rfc8259#section-3">RFC 8259, section 3</a>.
 */
@Composable
public interface JsonValue
{
    void serialize(JsonSink jsonSink) throws IOException;
}
