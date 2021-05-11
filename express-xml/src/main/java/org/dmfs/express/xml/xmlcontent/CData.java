package org.dmfs.express.xml.xmlcontent;

import org.dmfs.express.xml.Xml;
import org.dmfs.express.xml.XmlContent;
import org.dmfs.express.xml.fragment.CompositeXml;
import org.dmfs.express.xml.fragment.LiteralXml;
import org.dmfs.express.xml.fragment.Literals;
import org.dmfs.jems2.Single;
import org.dmfs.jems2.iterable.Expanded;
import org.dmfs.jems2.iterable.Seq;

import java.util.regex.Pattern;


/**
 * {@link Xml} CData.
 * <p>
 * If the CData contains a "]]>" Sequence, it's serialized as "]]]]><[CData[>" to ensure it's not interpreted as the end of the CData element.
 */
public final class CData extends CompositeXml implements XmlContent
{
    /**
     * A Pattern that matches the char location between "]]" and ">".
     */
    private final static Pattern CLOSING_SEQUENCE = Pattern.compile("(?<=]])(?=>)");


    public CData(String data)
    {
        this(() -> new org.dmfs.jems2.iterator.Seq<>(CLOSING_SEQUENCE.split(data)));
    }


    public CData(Single<String> data)
    {
        this(() -> new org.dmfs.jems2.iterator.Seq<>(CLOSING_SEQUENCE.split(data.value())));
    }


    private CData(Iterable<String> data)
    {
        super(new Expanded<>(
            d -> new Seq<>(Literals.OPENING_CDATA, new LiteralXml(d), Literals.CLOSING_CDATA),
            data));
    }
}
