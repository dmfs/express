package org.dmfs.express.json.elementary;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.json.confidence.Qualities.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;

/**
 * Unit test for {@link String}.
 */
public class StringTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new String(""), serializesTo("\"\""));
        assertThat(new String("1234"), serializesTo("\"1234\""));
        assertThat(new String("abcd"), serializesTo("\"abcd\""));
        assertThat(new String("\u0000\u0019\n\r\t\\\""), serializesTo("\"\\u0000\\u0019\\n\\r\\t\\\\\\\"\""));
        assertThat(new String("ab\ncd"), serializesTo("\"ab\\ncd\""));
        assertThat(new String("\nabcd"), serializesTo("\"\\nabcd\""));
        assertThat(new String("abcd\n"), serializesTo("\"abcd\\n\""));
        assertThat(new String("abcd\n/"), serializesTo("\"abcd\\n/\""));
        assertThat(new String("abcd\n\r\n\r"), serializesTo("\"abcd\\n\\r\\n\\r\""));
        assertThat(new String("abcd\n\r1234\n\rxyz"), serializesTo("\"abcd\\n\\r1234\\n\\rxyz\""));
        assertThat(new String("ab\tcd\n\r1234\n\rxyz"), serializesTo("\"ab\\tcd\\n\\r1234\\n\\rxyz\""));
        assertThat(new String("ab\\\t\\tcd\n\r1234\n\rxyz"), serializesTo("\"ab\\\\\\t\\\\tcd\\n\\r1234\\n\\rxyz\""));
    }

}