package org.dmfs.express.xml.qualifiedname;

import org.junit.Test;

import static org.dmfs.express.xml.hamcrest.QualifiedNameMatcher.qualifiedName;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link DefaultName}.
 *
 * @author Marten Gajda
 */
public class DefaultNameTest
{
    @Test
    public void test()
    {
        assertThat(new DefaultName("abc"), is(qualifiedName("", "abc")));
    }
}