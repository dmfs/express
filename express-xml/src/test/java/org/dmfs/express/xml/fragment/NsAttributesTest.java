package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.namespaceregistry.DefaultNamespaceRegistry;
import org.dmfs.jems2.iterable.Seq;
import org.junit.Test;

import static org.dmfs.express.xml.hamcrest.XmlSerializationMatcher.serializesTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Unit test for {@link NsAttributes}.
 *
 * @author Marten Gajda
 */
public class NsAttributesTest
{
    @Test
    public void test()
    {
        assertThat(
            new NsAttributes(),
            serializesTo(""));
        assertThat(
            new NsAttributes(),
            serializesTo(
                " xmlns:ns0=\"x\"",
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x")).left(),
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x")).right()));
        assertThat(
            new NsAttributes(),
            serializesTo(
                " xmlns:ns0=\"x\" xmlns:ns1=\"y\" xmlns:ns2=\"z\"",
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x", "y", "z")).left(),
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x", "y", "z")).right()));
        assertThat(
            new NsAttributes(),
            serializesTo(
                " xmlns:ns0=\"x\" xmlns:ns1=\"y\" xmlns:ns2=\"z\"",
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x", "y", "z", "x", "y", "z")).left(),
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x", "y", "z", "x", "y", "z")).right()));
    }
}