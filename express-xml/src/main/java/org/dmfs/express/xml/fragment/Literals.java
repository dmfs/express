package org.dmfs.express.xml.fragment;

import org.dmfs.express.xml.Xml;


/**
 * A collection of constants of XML literals.
 */
public final class Literals
{
    public final static Xml OPENING_COMMENT = new LiteralXml("<!--");
    public final static Xml CLOSING_COMMENT = new LiteralXml("-->");

    public final static Xml OPENING_CDATA = new LiteralXml("<![CDATA[");
    public final static Xml CLOSING_CDATA = new LiteralXml("]]>");

    public final static Xml OPENING_TAG_OPENING_ANGLE = new LiteralXml("<");
    public final static Xml CLOSING_TAG_OPENING_ANGLE = new LiteralXml("</");
    public final static Xml CLOSING_ANGLE = new LiteralXml(">");
    public final static Xml EMPTY_TAG_CLOSING_ANGLE = new LiteralXml("/>");

    public final static Xml WHITE_SPACE = new LiteralXml(" ");
    public final static Xml EQUALS = new LiteralXml("=");
    public final static Xml QUOTES = new LiteralXml("\"");
}
