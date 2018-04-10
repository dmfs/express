package org.dmfs.express.json.elementary;

import org.junit.Test;

import static org.dmfs.express.json.hamcrest.JsonSerializationMatcher.serializesTo;
import static org.junit.Assert.assertThat;


/**
 * Unit test for @{@link Number}.
 *
 * @author Marten Gajda
 */
public class NumberTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new Number(0), serializesTo("0"));
        assertThat(new Number(100), serializesTo("100"));
        assertThat(new Number(-100), serializesTo("-100"));
        assertThat(new Number(10_000_000_000L), serializesTo("10000000000"));
        assertThat(new Number(-10_000_000_000L), serializesTo("-10000000000"));
        assertThat(new Number(1f), serializesTo("1.0"));
        assertThat(new Number(-1f), serializesTo("-1.0"));
        assertThat(new Number(1.2345), serializesTo("1.2345"));
        assertThat(new Number(-1.2345), serializesTo("-1.2345"));
        assertThat(new Number(1.23E23), serializesTo("1.23E23"));
        assertThat(new Number(-1.23E23), serializesTo("-1.23E23"));
        assertThat(new Number(1.23E-23), serializesTo("1.23E-23"));
        assertThat(new Number(-1.23E-23), serializesTo("-1.23E-23"));
    }
}