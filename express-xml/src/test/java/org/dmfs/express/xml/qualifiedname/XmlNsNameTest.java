package org.dmfs.express.xml.qualifiedname;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.qualifiedName;
import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Grammar.is;

/**
 * Unit test for {@link XmlNsName}.
 *
 * @author Marten Gajda
 */
public class XmlNsNameTest
{
    @Test
    public void test()
    {
        assertThat(new XmlNsName("abc"), is(qualifiedName("http://www.w3.org/2000/xmlns/", "abc")));
    }
}