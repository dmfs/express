package org.dmfs.express.json;

import java.io.IOException;


/**
 * @author Marten Gajda
 */
public interface JsonSink
{
    void writeJson(CharSequence text) throws IOException;
}
