package org.dmfs.express.xml.xmlelement;

import org.dmfs.express.xml.attribute.Attr;
import org.dmfs.express.xml.attribute.XmlAttr;
import org.dmfs.express.xml.qualifiedname.Qn;
import org.dmfs.express.xml.xmlcontent.Text;
import org.dmfs.jems2.iterable.EmptyIterable;
import org.dmfs.jems2.iterable.Seq;
import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;


/**
 * Unit test for {@link Element}.
 */
public class ElementTest
{
    @Test
    public void test()
    {
        assertThat(
            new Element(new Qn("a", "b")),
            serializesTo("<ns0:b xmlns:ns0=\"a\"/>"));
        assertThat(
            new Element(new Qn("a", "b"),
                (xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("1"),
                (xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("2")),
            serializesTo("<ns0:b xmlns:ns0=\"a\">12</ns0:b>"));
        assertThat(
            new Element(new Qn("a", "b"),
                (xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("1")),
            serializesTo("<ns0:b xmlns:ns0=\"a\">1</ns0:b>"));
        assertThat(
            new Element(new Qn("a", "b"), "text"),
            serializesTo("<ns0:b xmlns:ns0=\"a\">text</ns0:b>"));
        assertThat(
            new Element(new Qn("a", "b"), () -> "text"),
            serializesTo("<ns0:b xmlns:ns0=\"a\">text</ns0:b>"));
        assertThat(
            new Element(
                new Qn("a", "b"),
                new Seq<>(
                    new Attr(new Qn("a", "c"), "d"),
                    new XmlAttr("lang", "de"))),
            serializesTo("<ns0:b ns0:c=\"d\" xml:lang=\"de\" xmlns:ns0=\"a\"/>"));
        assertThat(
            new Element(
                new Qn("a", "b"),
                new Seq<>(new Attr(new Qn("a", "c"), "d&c")),
                "text"),
            serializesTo("<ns0:b ns0:c=\"d&amp;c\" xmlns:ns0=\"a\">text</ns0:b>"));
        assertThat(
            new Element(
                new Qn("a", "b"),
                new Seq<>(new Attr(new Qn("a", "c"), "d")),
                () -> "text"),
            serializesTo("<ns0:b ns0:c=\"d\" xmlns:ns0=\"a\">text</ns0:b>"));
        assertThat(
            new Element(
                new Qn("a", "b"),
                new Seq<>(new Attr(new Qn("x", "c"), "d"))),
            serializesTo("<ns0:b ns1:c=\"d\" xmlns:ns0=\"a\" xmlns:ns1=\"x\"/>"));
        assertThat(
            new Element(
                new Qn("a", "b"),
                new Seq<>(new Attr(new Qn("x", "c"), "d")),
                new Seq<>(new Text("1"), new Text("2"), new Text("3"))),
            serializesTo("<ns0:b ns1:c=\"d\" xmlns:ns0=\"a\" xmlns:ns1=\"x\">123</ns0:b>"));
        assertThat(
            new Element(
                new Qn("x", "a"),
                new Seq<>(new Attr(new Qn("z", "r"), "123"))),
            serializesTo("<ns0:a ns1:r=\"123\" xmlns:ns0=\"x\" xmlns:ns1=\"z\"/>"));
        assertThat(
            new Element(
                new Qn("x", "a"),
                new Seq<>(new Attr(new Qn("z", "r"), "123")),
                new EmptyIterable<>()),
            serializesTo("<ns0:a ns1:r=\"123\" xmlns:ns0=\"x\" xmlns:ns1=\"z\"/>"));
        assertThat(
            new Element(new Qn("x", "a"),
                new Seq<>(new Attr(new Qn("z", "r"), "123")),
                new Element(new Qn("x", "b"))),
            serializesTo("<ns0:a ns1:r=\"123\" xmlns:ns0=\"x\" xmlns:ns1=\"z\"><ns0:b/></ns0:a>"));
        assertThat(
            new Element(new Qn("x", "a"),
                new Seq<>(new Attr(new Qn("z", "r"), "123")),
                new Element(new Qn("x", "b")),
                new Element(new Qn("x", "c"))),
            serializesTo("<ns0:a ns1:r=\"123\" xmlns:ns0=\"x\" xmlns:ns1=\"z\"><ns0:b/><ns0:c/></ns0:a>"));
    }
}