package org.dmfs.express.xml.xmlelement;

import org.junit.Test;

import static org.dmfs.express.xml.hamcrest.XmlSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link Composite}.
 *
 * @author Marten Gajda
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