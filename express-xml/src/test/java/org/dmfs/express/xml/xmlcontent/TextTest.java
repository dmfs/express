package org.dmfs.express.xml.xmlcontent;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;

/**
 * Unit test for {@link Text}.
 */
public class TextTest
{
    @Test
    public void test()
    {
        assertThat(new Text(""), serializesTo(""));
        assertThat(new Text("abc"), serializesTo("abc"));
        assertThat(new Text("\""), serializesTo("&quot;"));
        assertThat(new Text("abc\"xyz"), serializesTo("abc&quot;xyz"));
        assertThat(new Text("&\"<>"), serializesTo("&amp;&quot;&lt;&gt;"));
    }
}