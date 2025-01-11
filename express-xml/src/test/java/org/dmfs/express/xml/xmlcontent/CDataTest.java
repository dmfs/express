package org.dmfs.express.xml.xmlcontent;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;

/**
 * Unit test for {@link CData}.
 */
public class CDataTest
{
    @Test
    public void test()
    {
        assertThat(new CData(""), serializesTo("<![CDATA[]]>"));
        assertThat(new CData("abc"), serializesTo("<![CDATA[abc]]>"));
        assertThat(new CData("ab<![CDATA[c"), serializesTo("<![CDATA[ab<![CDATA[c]]>"));
        assertThat(new CData("ab]c"), serializesTo("<![CDATA[ab]c]]>"));
        assertThat(new CData("ab]]c"), serializesTo("<![CDATA[ab]]c]]>"));
        assertThat(new CData("ab]>c"), serializesTo("<![CDATA[ab]>c]]>"));
        assertThat(new CData("ab]]>c"), serializesTo("<![CDATA[ab]]]]><![CDATA[>c]]>"));
        assertThat(new CData("ab]]>]]>c"), serializesTo("<![CDATA[ab]]]]><![CDATA[>]]]]><![CDATA[>c]]>"));

        assertThat(new CData(() -> ""), serializesTo("<![CDATA[]]>"));
        assertThat(new CData(() -> "abc"), serializesTo("<![CDATA[abc]]>"));
        assertThat(new CData(() -> "ab<![CDATA[c"), serializesTo("<![CDATA[ab<![CDATA[c]]>"));
        assertThat(new CData(() -> "ab]c"), serializesTo("<![CDATA[ab]c]]>"));
        assertThat(new CData(() -> "ab]]c"), serializesTo("<![CDATA[ab]]c]]>"));
        assertThat(new CData(() -> "ab]>c"), serializesTo("<![CDATA[ab]>c]]>"));
        assertThat(new CData(() -> "ab]]>c"), serializesTo("<![CDATA[ab]]]]><![CDATA[>c]]>"));
        assertThat(new CData(() -> "ab]]>]]>c"), serializesTo("<![CDATA[ab]]]]><![CDATA[>]]]]><![CDATA[>c]]>"));
    }
}