package org.dmfs.express.xml.qualifiedname;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.xml.confidence.Xml.qualifiedName;
import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Grammar.is;

/**
 * Unit test for {@link Qn}.
 */
public class QnTest
{
    @Test
    public void test()
    {
        assertThat(new Qn("ns", "abc"), is(qualifiedName("ns", "abc")));
    }
}