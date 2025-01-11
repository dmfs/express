package org.dmfs.express.json.elementary;

import org.dmfs.express.json.JsonSink;
import org.dmfs.express.json.JsonValue;
import org.dmfs.jems2.charsequence.Hex;

import java.io.IOException;


/**
 * A String {@link JsonValue}.
 */
public final class String implements JsonValue
{
    private final CharSequence mString;


    public String(CharSequence string)
    {
        mString = string;
    }


    @Override
    public void serialize(JsonSink jsonSink) throws IOException
    {
        jsonSink.writeJson("\"");

        // TODO: this is merely a quick and dirty implementation. it appears to work correctly, but can use some improvements
        int start = 0;
        int end = 0;
        int length = mString.length();
        while (end < length)
        {
            char c = mString.charAt(end);
            // check for any characters which need special treatment
            if (c < 0x20 || c == 0x22 || c == 0x5c)
            {
                if (start != end)
                {
                    // write everything which didn't need encoding up to this point
                    jsonSink.writeJson(mString.subSequence(start, end));
                }
                if (c >= 0x20)
                {
                    // these will just be escaped
                    jsonSink.writeJson("\\");
                    jsonSink.writeJson(new java.lang.String(new char[] { c }));
                }
                else if (c == 0x0a)
                {
                    jsonSink.writeJson("\\n");
                }
                else if (c == 0x0d)
                {
                    jsonSink.writeJson("\\r");
                }
                else if (c == 0x09)
                {
                    jsonSink.writeJson("\\t");
                }
                else
                {
                    // anything else below 0x0020 needs to be encoded
                    jsonSink.writeJson("\\u00");
                    jsonSink.writeJson(new Hex(new byte[] { (byte) c }));
                }
                start = end + 1;
            }
            end += 1;
        }
        if (start != end)
        {
            // write any remaining chars
            jsonSink.writeJson(mString.subSequence(start, end));
        }

        jsonSink.writeJson("\"");
    }
}
