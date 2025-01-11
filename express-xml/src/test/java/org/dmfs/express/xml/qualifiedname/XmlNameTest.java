package org.dmfs.express.xml.qualifiedname;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.qualifiedName;
import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Grammar.is;

/**
 * Unit test for {@link XmlName}.
 *
 * @author Marten Gajda
 */
public class XmlNameTest
{
    @Test
    public void test()
    {
        assertThat(new XmlName("abc"), is(qualifiedName("http://www.w3.org/XML/1998/namespace", "abc")));
    }
}