package org.dmfs.express.xml.xmlelement;

import org.dmfs.express.xml.qualifiedname.Qn;
import org.dmfs.jems2.iterable.Seq;
import org.junit.Test;

import static org.dmfs.express.xml.hamcrest.XmlSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link NsRegistered}.
 *
 * @author Marten Gajda
 */
public class NsRegisteredTest
{
    @Test
    public void test()
    {
        assertThat(
            new NsRegistered(
                new Seq<>(),
                new Element(new Qn("a", "b"))),
            serializesTo("<ns0:b xmlns:ns0=\"a\"/>"));
        assertThat(
            new NsRegistered(
                new Seq<>("a"),
                new Element(new Qn("a", "b"))),
            serializesTo("<ns0:b xmlns:ns0=\"a\"/>"));
        assertThat(
            new NsRegistered(
                new Seq<>("x"),
                new Element(new Qn("a", "b"))),
            serializesTo("<ns1:b xmlns:ns1=\"a\" xmlns:ns0=\"x\"/>"));
        assertThat(
            new NsRegistered(
                new Seq<>("x", "a", "y", "z"),
                new Element(new Qn("a", "b"))),
            serializesTo("<ns1:b xmlns:ns1=\"a\" xmlns:ns0=\"x\" xmlns:ns2=\"y\" xmlns:ns3=\"z\"/>"));
        assertThat(
            new NsRegistered(
                new Seq<>("x", "y", "z"),
                new Element(new Qn("a", "b"))),
            serializesTo("<ns3:b xmlns:ns3=\"a\" xmlns:ns0=\"x\" xmlns:ns1=\"y\" xmlns:ns2=\"z\"/>"));
    }
}