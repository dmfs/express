package org.dmfs.express.xml.qualifiedname;

import org.junit.Test;

import static org.dmfs.express.xml.hamcrest.QualifiedNameMatcher.qualifiedName;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


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