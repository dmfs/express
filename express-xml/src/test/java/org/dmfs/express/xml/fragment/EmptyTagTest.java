package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.namespaceregistry.DefaultNamespaceRegistry;
import org.dmfs.express.xml.qualifiedname.Qn;
import org.dmfs.jems2.iterable.EmptyIterable;
import org.dmfs.jems2.iterable.Seq;
import org.junit.Test;

import static org.dmfs.express.xml.hamcrest.XmlSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link EmptyTag}.
 *
 * @author Marten Gajda
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
            serializesTo("<ns0:b xmlns:ns0=\"a\"/>",
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("a")).left(),
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("a")).right()));
        assertThat(
            new EmptyTag(
                new Qn("a", "b")),
            serializesTo("<ns0:b/>",
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("a")).left(),
                new EmptyIterable<>()));
    }
}