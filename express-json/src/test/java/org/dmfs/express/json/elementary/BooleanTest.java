package org.dmfs.express.json.elementary;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.json.confidence.Qualities.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;

/**
 * Unit test for {@link Boolean}.
 */
public class BooleanTest
{
    @Test
    public void testSerialize() throws Exception
    {
        assertThat(new Boolean(true), serializesTo("true"));
        assertThat(Boolean.TRUE, serializesTo("true"));
        assertThat(new Boolean(false), serializesTo("false"));
        assertThat(Boolean.FALSE, serializesTo("false"));
    }

}