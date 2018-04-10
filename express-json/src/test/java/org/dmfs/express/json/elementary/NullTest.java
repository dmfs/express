package org.dmfs.express.json.elementary;

import org.junit.Test;

import static org.dmfs.express.json.hamcrest.JsonSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


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