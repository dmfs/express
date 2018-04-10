package org.dmfs.express.json.elementary;

import org.junit.Test;

import java.io.IOException;

import static org.dmfs.jems.hamcrest.matchers.SingleMatcher.hasValue;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link JsonText}.
 *
 * @author Marten Gajda
 */
public class JsonTextTest
{
    @Test
    public void testValue()
    {
        assertThat(new JsonText(new String("123")), hasValue("\"123\""));
    }


    @Test(expected = RuntimeException.class)
    public void testFailure()
    {
        new JsonText(jsonSink -> {
            throw new IOException();
        }).value();
    }

}