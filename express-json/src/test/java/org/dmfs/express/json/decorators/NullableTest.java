package org.dmfs.express.json.decorators;

import org.dmfs.express.json.JsonValue;
import org.dmfs.express.json.elementary.Object;
import org.junit.Test;

import static org.dmfs.express.json.hamcrest.JsonSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link Nullable}.
 *
 * @author Marten Gajda
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