package org.dmfs.express.json.elementary;

import org.junit.jupiter.api.Test;

import static org.dmfs.express.json.confidence.Qualities.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;


/**
 * Unit test for @{@link Number}.
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