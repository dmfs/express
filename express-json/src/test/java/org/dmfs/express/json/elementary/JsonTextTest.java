package org.dmfs.express.json.elementary;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.dmfs.jems2.confidence.Jems2.hasValue;
import static org.dmfs.jems2.confidence.Jems2.throwing;
import static org.saynotobugs.confidence.Assertion.assertThat;


/**
 * Unit test for {@link JsonText}.
 */
public class JsonTextTest
{
    @Test
    public void testJsonableValue()
    {
        assertThat(new JsonText(() -> new String("123")), hasValue("\"123\""));
    }

    @Test
    public void testValue()
    {
        assertThat(new JsonText(new String("123")), hasValue("\"123\""));
    }

    @Test
    public void testFailure()
    {
        assertThat(new JsonText(jsonSink -> {
            throw new IOException("Unable to serialize");
        }), throwing(RuntimeException.class));
    }

}