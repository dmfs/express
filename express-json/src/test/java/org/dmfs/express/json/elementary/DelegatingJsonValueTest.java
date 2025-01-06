package org.dmfs.express.json.elementary;


import org.junit.jupiter.api.Test;

import static org.dmfs.express.json.confidence.Qualities.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;


/**
 * Unit test for {@link DelegatingJsonValue}.
 *
 * @author Marten Gajda
 */
public class DelegatingJsonValueTest
{
    @Test
    public void testSerialize()
    {
        assertThat(new DelegatingJsonValue(new String("123"))
                   {
                   },
            serializesTo("\"123\""));
    }

}