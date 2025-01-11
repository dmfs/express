package org.dmfs.express.xml.xmlelement;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;

/**
 * Unit test for {@link Composite}.
 */
public class CompositeTest
{
    @Test
    public void test()
    {
        assertThat(
            new Composite(
                (xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("a")),
            serializesTo("a"));
        assertThat(
            new Composite(
                (xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("a"),
                (xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("b"),
                (xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("c")),
            serializesTo("abc"));
    }
}