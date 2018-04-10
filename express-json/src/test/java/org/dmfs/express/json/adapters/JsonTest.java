package org.dmfs.express.json.adapters;

import org.dmfs.express.json.elementary.String;
import org.junit.Test;

import static org.dmfs.express.json.hamcrest.JsonSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link Json}.
 *
 * @author marten
 */
public class JsonTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new Json(() -> new String("json test")), serializesTo("\"json test\""));
    }

}