package org.dmfs.express.json.hamcrest;

import org.dmfs.express.json.JsonValue;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.io.IOException;


/**
 * A {@link Matcher} which checks the serialization of a {@link JsonValue}.
 * <p>
 * TODO: move to separate module
 *
 * @author Marten Gajda
 */
public final class JsonSerializationMatcher extends TypeSafeDiagnosingMatcher<JsonValue>
{
    private final String mJsonText;


    public JsonSerializationMatcher(String jsonText)
    {
        mJsonText = jsonText;
    }


    public static Matcher<JsonValue> serializesTo(String expectedText)
    {
        return new JsonSerializationMatcher(expectedText);
    }


    @Override
    protected boolean matchesSafely(JsonValue item, Description mismatchDescription)
    {
        StringBuilder sb = new StringBuilder();

        try
        {
            item.serialize(sb::append);
        }
        catch (IOException e)
        {
            mismatchDescription.appendText(String.format("threw %s", e.getClass().getName()));
            return false;
        }

        if (!mJsonText.equals(sb.toString()))
        {
            mismatchDescription.appendText(String.format("serialized to '%s'", sb.toString()));
            return false;
        }
        return true;
    }


    @Override
    public void describeTo(Description description)
    {
        description.appendText(String.format("serializes to '%s'", mJsonText));
    }
}
