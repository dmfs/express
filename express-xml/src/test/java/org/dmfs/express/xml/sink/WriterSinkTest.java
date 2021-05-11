package org.dmfs.express.xml.sink;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Unit test for {@link WriterSink}.
 *
 * @author Marten Gajda
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