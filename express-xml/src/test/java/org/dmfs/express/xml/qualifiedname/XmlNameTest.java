package org.dmfs.express.xml.qualifiedname;

import org.junit.Test;

import static org.dmfs.express.xml.hamcrest.QualifiedNameMatcher.qualifiedName;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


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