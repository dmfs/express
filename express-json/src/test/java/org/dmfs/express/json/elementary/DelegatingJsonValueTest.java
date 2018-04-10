package org.dmfs.express.json.elementary;

import org.junit.Test;

import static org.dmfs.express.json.hamcrest.JsonSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link DelegatingJsonValue}.
 *
 * @author Marten Gajda
 */
public class DelegatingJsonValueTest
{
    @Test
    public void testSerialize() throws Exception
    {
        assertThat(new DelegatingJsonValue(new String("123"))
        {
        }, serializesTo("\"123\""));
    }

}