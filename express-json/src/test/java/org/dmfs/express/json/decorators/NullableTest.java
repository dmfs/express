package org.dmfs.express.json.decorators;

import org.dmfs.express.json.JsonValue;
import org.dmfs.express.json.elementary.Object;
import org.junit.jupiter.api.Test;

import static org.dmfs.express.json.confidence.Qualities.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;


/**
 * Unit test for {@link Nullable}.
 */
public class NullableTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new Nullable((String) null), serializesTo("null"));
        assertThat(new Nullable((Number) null), serializesTo("null"));
        assertThat(new Nullable((Boolean) null), serializesTo("null"));
        assertThat(new Nullable((JsonValue) null), serializesTo("null"));

        assertThat(new Nullable("123"), serializesTo("\"123\""));
        assertThat(new Nullable(123), serializesTo("123"));
        assertThat(new Nullable(true), serializesTo("true"));
        assertThat(new Nullable(new Object()), serializesTo("{}"));
    }

}