package org.dmfs.express.json.elementary;

import org.dmfs.express.json.JsonValue;
import org.dmfs.express.json.Jsonable;
import org.dmfs.jems2.iterable.EmptyIterable;
import org.dmfs.jems2.iterable.Seq;
import org.junit.Test;

import static org.dmfs.express.json.hamcrest.JsonSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link Array}.
 *
 * @author Marten Gajda
 */
public class ArrayTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new Array(), serializesTo("[]"));
        assertThat(new Array(new Jsonable[0]), serializesTo("[]"));
        assertThat(new Array(new java.lang.Boolean[0]), serializesTo("[]"));
        assertThat(new Array(new java.lang.Number[0]), serializesTo("[]"));
        assertThat(new Array(new java.lang.String[0]), serializesTo("[]"));
        assertThat(new Array(new JsonValue[0]), serializesTo("[]"));
        assertThat(new Array(new EmptyIterable<>()), serializesTo("[]"));

        assertThat(new Array((Jsonable) Object::new), serializesTo("[{}]"));
        assertThat(new Array(true), serializesTo("[true]"));
        assertThat(new Array(1), serializesTo("[1]"));
        assertThat(new Array("abc"), serializesTo("[\"abc\"]"));
        assertThat(new Array(new String("abc")), serializesTo("[\"abc\"]"));
        assertThat(new Array(new Seq<>(new String("abc"))), serializesTo("[\"abc\"]"));

        assertThat(new Array(Object::new, () -> new Boolean(true)), serializesTo("[{},true]"));
        assertThat(new Array(true, false), serializesTo("[true,false]"));
        assertThat(new Array(1, 2), serializesTo("[1,2]"));
        assertThat(new Array("abc", "xyz"), serializesTo("[\"abc\",\"xyz\"]"));
        assertThat(new Array(new String("abc"), new Number(123)), serializesTo("[\"abc\",123]"));
        assertThat(new Array(new Seq<>(new String("abc"), new Number(123))), serializesTo("[\"abc\",123]"));
    }

}