package org.dmfs.express.xml.utils;

import org.junit.Test;

import java.io.IOException;

import static org.dmfs.jems2.hamcrest.matchers.fragile.BrokenFragileMatcher.throwing;
import static org.dmfs.jems2.hamcrest.matchers.single.SingleMatcher.hasValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link XmlString}.
 *
 * @author Marten Gajda
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