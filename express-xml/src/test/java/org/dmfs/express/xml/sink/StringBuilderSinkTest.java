package org.dmfs.express.xml.sink;

import org.junit.Test;

import static org.hamcrest.Matchers.hasToString;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link StringBuilderSink}.
 *
 * @author Marten Gajda
 */
public class StringBuilderSinkTest
{
    @Test
    public void testEmpty()
    {
        StringBuilder sb = new StringBuilder();
        new StringBuilderSink(sb).writeText("");
        assertThat(sb, hasToString(""));
    }


    @Test
    public void testNonEmpty()
    {
        StringBuilder sb = new StringBuilder();
        new StringBuilderSink(sb).writeText("xyz");
        assertThat(sb, hasToString("xyz"));
    }
}