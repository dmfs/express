package org.dmfs.express.xml.qualifiedname;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.qualifiedName;
import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Grammar.is;

/**
 * Unit test for {@link DefaultName}.
 */
public class DefaultNameTest
{
    @Test
    public void test()
    {
        assertThat(new DefaultName("abc"), is(qualifiedName("", "abc")));
    }
}