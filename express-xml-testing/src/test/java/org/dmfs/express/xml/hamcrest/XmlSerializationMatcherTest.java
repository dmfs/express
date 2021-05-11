package org.dmfs.express.xml.hamcrest;

import org.junit.Test;

import java.io.IOException;

import static org.dmfs.express.xml.hamcrest.XmlSerializationMatcher.serializesTo;
import static org.dmfs.jems2.hamcrest.matchers.matcher.MatcherMatcher.*;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link XmlSerializationMatcher}.
 *
 * @author Marten Gajda
 */
public class XmlSerializationMatcherTest
{
    @Test
    public void test()
    {
        assertThat(
            serializesTo("abc"),
            matches((xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("abc")));
        assertThat(
            serializesTo("abc"),
            mismatches((xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("xyz"), "serialized to 'xyz'"));
        assertThat(
            serializesTo("abc"),
            mismatches((xmlSink, namespaceRegistry, unregisteredPrefixes) -> {
                throw new IOException("ex");
            }, "threw java.io.IOException"));
        assertThat(
            serializesTo("xyz"),
            describesAs("serializes to 'xyz'"));
    }
}