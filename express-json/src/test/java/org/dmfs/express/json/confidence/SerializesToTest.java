package org.dmfs.express.json.confidence;

import org.junit.jupiter.api.Test;

import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Composite.allOf;
import static org.saynotobugs.confidence.test.quality.Quality.fails;
import static org.saynotobugs.confidence.test.quality.Quality.passes;

class SerializesToTest
{
    @Test
    public void testMatchesAndNonMatches() throws Exception
    {
        assertThat(new SerializesTo("\"123\""),
            allOf(
                passes(new org.dmfs.express.json.elementary.String("123")),
                fails(new org.dmfs.express.json.elementary.String("124"))));
    }
}