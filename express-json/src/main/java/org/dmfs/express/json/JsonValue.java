package org.dmfs.express.json;

import java.io.IOException;


/**
 * A JSON value as per <a href="https://tools.ietf.org/html/rfc8259#section-3">RFC 8259, section 3</a>.
 *
 * @author Marten Gajda
 */
public interface JsonValue
{
    void serialize(JsonSink jsonSink) throws IOException;
}
