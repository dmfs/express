package org.dmfs.express.json.elementary;

import org.junit.Test;

import static org.dmfs.express.json.hamcrest.JsonSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


/**
 * @author Marten Gajda
 */
public class ObjectTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new Object(), serializesTo("{}"));
        assertThat(new Object(new Member("a", 1)), serializesTo("{\"a\":1}"));
        assertThat(new Object(new Member("a", 1), new Member("x", "y")), serializesTo("{\"a\":1,\"x\":\"y\"}"));
        assertThat(new Object(new Member("a", new Object()), new Member("x", "y")), serializesTo("{\"a\":{},\"x\":\"y\"}"));
        assertThat(new Object(new Member("a", new Object(new Member("b", "q"))), new Member("x", new Array(1, 2, 3))),
            serializesTo("{\"a\":{\"b\":\"q\"},\"x\":[1,2,3]}"));
    }

}