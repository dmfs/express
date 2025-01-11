package org.dmfs.express.json.adapters;

import org.dmfs.express.json.elementary.String;
import org.junit.jupiter.api.Test;

import static org.dmfs.express.json.confidence.Qualities.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;


public class JsonTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new Json(() -> new String("json test")), serializesTo("\"json test\""));
    }

}