package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.namespaceregistry.DefaultNamespaceRegistry;
import org.dmfs.jems2.iterable.Seq;
import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;


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
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x")).left(),
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x")).right(),
                " xmlns:ns0=\"x\""));
        assertThat(
            new NsAttributes(),
            serializesTo(
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x", "y", "z")).left(),
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x", "y", "z")).right(),
                " xmlns:ns0=\"x\" xmlns:ns1=\"y\" xmlns:ns2=\"z\""));
        assertThat(
            new NsAttributes(),
            serializesTo(
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x", "y", "z", "x", "y", "z")).left(),
                new DefaultNamespaceRegistry().withNamespaces(new Seq<>("x", "y", "z", "x", "y", "z")).right(),
                " xmlns:ns0=\"x\" xmlns:ns1=\"y\" xmlns:ns2=\"z\""));
    }
}