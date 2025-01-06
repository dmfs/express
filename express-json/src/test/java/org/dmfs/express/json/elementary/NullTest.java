package org.dmfs.express.json.elementary;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.json.confidence.Qualities.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;

/**
 * Test for {@link Null}.
 *
 * @author Marten Gajda
 */
public class NullTest
{
    @Test
    public void test()
    {
        assertThat(new Null(), serializesTo("null"));
    }
}