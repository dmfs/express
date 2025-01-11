package org.dmfs.express.xml.sink;


import org.junit.jupiter.api.Test;

import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Object.hasToString;

/**
 * Unit test for {@link StringBuilderSink}.
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