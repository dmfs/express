package org.dmfs.express.xml.sink;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Grammar.is;


/**
 * Unit test for {@link WriterSink}.
 */
public class WriterSinkTest
{
    @Test
    public void test() throws IOException
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Writer w = new OutputStreamWriter(out);
        new WriterSink(w).writeText("test");
        w.flush();
        assertThat(out.toByteArray(), is("test".getBytes()));
    }
}