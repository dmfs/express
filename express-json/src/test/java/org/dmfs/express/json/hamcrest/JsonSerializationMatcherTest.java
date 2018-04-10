package org.dmfs.express.json.hamcrest;

import org.dmfs.express.json.JsonValue;
import org.dmfs.express.json.elementary.String;
import org.hamcrest.Description;
import org.hamcrest.StringDescription;
import org.junit.Test;

import java.io.IOException;

import static org.dmfs.express.json.hamcrest.JsonSerializationMatcher.serializesTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link JsonSerializationMatcher}.
 *
 * @author marten
 */
public class JsonSerializationMatcherTest
{
    @Test
    public void testMatchesAndNonMatches() throws Exception
    {
        assertThat(serializesTo("\"123\"").matches(new String("123")), is(true));
        assertThat(serializesTo("\"123\"").matches(new String("124")), is(false));
    }


    @Test
    public void testMismatchDescription() throws Exception
    {
        Description description = new StringDescription();
        serializesTo("\"123\"").describeMismatch(new String("124"), description);
        assertThat(description.toString(), is("serialized to '\"124\"'"));
    }


    @Test
    public void testExceptionDescription() throws Exception
    {
        Description description = new StringDescription();
        serializesTo("\"123\"").describeMismatch((JsonValue) jsonSink -> {
            throw new IOException();
        }, description);
        assertThat(description.toString(), is("threw java.io.IOException"));
    }


    @Test
    public void testDescribeTo() throws Exception
    {
        Description description = new StringDescription();
        serializesTo("\"123\"").describeTo(description);
        assertThat(description.toString(), is("serializes to '\"123\"'"));
    }

}