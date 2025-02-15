package org.dmfs.express.xml.xmlcontent;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;

/**
 * Unit test for {@link Composite}
 */
public class CompositeTest
{
    @Test
    public void test()
    {
        assertThat(new Composite(), serializesTo(""));
        assertThat(new Composite((xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("x")), serializesTo("x"));
        assertThat(new Composite(
                (xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("x"),
                (xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("y")),
            serializesTo("xy"));
    }
}