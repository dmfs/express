package org.dmfs.express.xml.xmlelement;

import org.dmfs.express.xml.Attribute;
import org.dmfs.express.xml.QualifiedName;
import org.dmfs.express.xml.XmlContent;
import org.dmfs.express.xml.XmlElement;
import org.dmfs.express.xml.fragment.ClosingTag;
import org.dmfs.express.xml.fragment.EmptyTag;
import org.dmfs.express.xml.fragment.NsCleared;
import org.dmfs.express.xml.fragment.OpeningTag;
import org.dmfs.express.xml.utils.NonEmpty;
import org.dmfs.express.xml.xmlcontent.Text;
import org.dmfs.jems2.Single;
import org.dmfs.jems2.iterable.Joined;
import org.dmfs.jems2.iterable.Just;
import org.dmfs.jems2.iterable.Mapped;
import org.dmfs.jems2.iterable.Seq;
import org.dmfs.jems2.single.Backed;


/**
 * The basic {@link XmlElement}. This should be used to compose all XML elements.
 */
public final class Element extends CompositeElement
{
    /**
     * Creates an empty element without attributes.
     */
    public Element(QualifiedName qualifiedName)
    {
        this(new Just<>(qualifiedName.namespace()),
            new Composite(new EmptyTag(qualifiedName)));
    }


    /**
     * Creates an element with the given children and no attributes.
     */
    public Element(QualifiedName qualifiedName, XmlContent... children)
    {
        this(new Just<>(qualifiedName.namespace()),
            new Composite(
                new OpeningTag(qualifiedName),
                new NsCleared(new org.dmfs.express.xml.xmlcontent.Composite(new Seq<>(children))),
                new ClosingTag(qualifiedName)));
    }


    /**
     * Creates an Element with a text child and no attributes.
     */
    public Element(QualifiedName qualifiedName, String text)
    {
        this(new Just<>(qualifiedName.namespace()),
            new Composite(
                new OpeningTag(qualifiedName),
                new Text(text),
                new ClosingTag(qualifiedName)));
    }


    /**
     * Creates an Element with a text child and no attributes.
     */
    public Element(QualifiedName qualifiedName, Single<String> text)
    {
        this(new Just<>(qualifiedName.namespace()),
            new Composite(
                new OpeningTag(qualifiedName),
                new Text(text),
                new ClosingTag(qualifiedName)));
    }


    /**
     * Creates an empty Element with the given attributes.
     */
    public Element(QualifiedName qualifiedName, Iterable<? extends Attribute> attributes)
    {
        this(new Joined<>(
                new Just<>(qualifiedName.namespace()),
                new Mapped<>(p -> p.name().namespace(), attributes)),
            new Composite(new EmptyTag(qualifiedName, attributes)));
    }


    /**
     * Creates an element with the given text content and attributes.
     */
    public Element(QualifiedName qualifiedName, Iterable<? extends Attribute> attributes, String text)
    {
        this(qualifiedName, attributes, new Just<>(new Text(text)));
    }


    /**
     * Creates an element with the given text content and attributes.
     */
    public Element(QualifiedName qualifiedName, Iterable<? extends Attribute> attributes, Single<String> text)
    {
        this(qualifiedName, attributes, new Just<>(new Text(text)));
    }


    /**
     * Creates an element with the given children and attributes.
     */
    public Element(QualifiedName qualifiedName, Iterable<? extends Attribute> attributes, XmlContent... children)
    {
        this(qualifiedName, attributes, new Seq<>(children));
    }


    /**
     * Creates an element with the given children and attributes.
     */
    public Element(QualifiedName qualifiedName, Iterable<? extends Attribute> attributes, Iterable<? extends XmlContent> children)
    {
        this(new Joined<>(
                new Just<>(qualifiedName.namespace()),
                new Mapped<>(p -> p.name().namespace(), attributes)),
            new Composite(
                new Backed<>(
                    new org.dmfs.jems2.optional.Mapped<>(
                        cc -> new Seq<>(
                            new OpeningTag(qualifiedName, attributes),
                            new NsCleared(new org.dmfs.express.xml.xmlcontent.Composite(cc)),
                            new ClosingTag(qualifiedName)),
                        new NonEmpty<>(children)),
                    new Just<>(new EmptyTag(qualifiedName, attributes)))));
    }


    private Element(Iterable<String> namespaces, XmlElement delegateElement)
    {
        super(new NsRegistered(namespaces, delegateElement));
    }
}
