package org.dmfs.express.json;

import org.dmfs.srcless.annotations.composable.Composable;

import java.io.IOException;


/**
 *
 */
@Composable
public interface JsonSink
{
    void writeJson(CharSequence text) throws IOException;
}
