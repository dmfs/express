package org.dmfs.express.xml.utils;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.dmfs.jems2.confidence.Jems2.hasValue;
import static org.dmfs.jems2.confidence.Jems2.throwing;
import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Grammar.is;


/**
 * Unit test for {@link XmlString}.
 */
public class XmlStringTest
{
    @Test
    public void test()
    {
        assertThat(
            new XmlString((xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("x")),
            hasValue("x"));
        assertThat(() -> new XmlString((xmlSink, namespaceRegistry, unregisteredPrefixes) -> {
                throw new IOException("error");
            }).value(),
            is(throwing(RuntimeException.class)));
    }
}