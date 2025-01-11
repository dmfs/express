package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.namespaceregistry.DefaultNamespaceRegistry;
import org.dmfs.express.xml.qualifiedname.Qn;
import org.dmfs.jems2.iterable.EmptyIterable;
import org.dmfs.jems2.iterable.Seq;
import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;


/**
 * Unit test for {@link EmptyTag}.
 */
public class EmptyTagTest
{
    @Test
    public void test()
    {
        assertThat(
            new EmptyTag(new Qn("", "b")),
            serializesTo("<b/>"));
        assertThat(
            new EmptyTag(
                new Qn("a", "b")),
            serializesTo(
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("a")).left(),
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("a")).right(),
                "<ns0:b xmlns:ns0=\"a\"/>"));
        assertThat(
            new EmptyTag(
                new Qn("a", "b")),
            serializesTo(
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("a")).left(),
                new EmptyIterable<>(),
                "<ns0:b/>"));
    }
}