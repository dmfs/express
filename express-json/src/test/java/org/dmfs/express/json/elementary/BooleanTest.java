package org.dmfs.express.json.elementary;

import org.junit.Test;

import static org.dmfs.express.json.hamcrest.JsonSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link Boolean}.
 *
 * @author Marten Gajda
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