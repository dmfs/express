package org.dmfs.express.xml.xmlcontent;

import org.dmfs.express.xml.*;
import org.dmfs.jems2.Single;

import java.io.IOException;


/**
 * An {@link Xml} text element.
 */
public final class Text implements XmlContent
{
    private final static long ESCAPE_BITMAP = (1L << '"') | (1L << '&') | (1L << '<') | (1L << '>');
    private final Single<String> mText;


    public Text(String text)
    {
        this(() -> text);
    }


    public Text(Single<String> text)
    {
        mText = text;
    }


    @Override
    public void serialize(
        XmlSink xmlSink,
        NamespaceRegistry namespaceRegistry,
        Iterable<? extends NamespaceBinding> unregisteredPrefixes) throws IOException
    {
        String text = mText.value();
        int pos = 0;
        for (int i = 0, len = text.length(); i < len; ++i)
        {
            char c = text.charAt(i);
            if (c <= '>' && (ESCAPE_BITMAP & (1L << c)) != 0)
            {
                xmlSink.writeText(text.substring(pos, i));
                switch (c)
                {
                    case '"':
                        xmlSink.writeText("&quot;");
                        break;
                    case '&':
                        xmlSink.writeText("&amp;");
                        break;
                    case '<':
                        xmlSink.writeText("&lt;");
                        break;
                    case '>':
                        xmlSink.writeText("&gt;");
                        break;
                }
                pos = i + 1;
            }
        }
        xmlSink.writeText(text.substring(pos));
    }
}
