package org.dmfs.express.xml.hamcrest;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.Xml;
import org.dmfs.express.xml.namespaceregistry.DefaultNamespaceRegistry;
import org.dmfs.express.xml.sink.StringBuilderSink;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.io.IOException;

import static org.dmfs.jems2.iterable.EmptyIterable.emptyIterable;


/**
 * A {@link Matcher} which checks the serialization of an {@link Xml} snippet.
 */
public final class XmlSerializationMatcher extends TypeSafeDiagnosingMatcher<Xml>
{
    private final String mXmlText;
    private final NamespaceRegistry mNamespaceRegistry;
    private final Iterable<? extends NamespaceBinding> mUnregisteredNamespaces;


    public XmlSerializationMatcher(String jsonText, NamespaceRegistry namespaceRegistry, Iterable<? extends NamespaceBinding> unregisteredNamespaces)
    {
        mXmlText = jsonText;
        mNamespaceRegistry = namespaceRegistry;
        mUnregisteredNamespaces = unregisteredNamespaces;
    }


    public static Matcher<Xml> serializesTo(String expectedText, NamespaceRegistry ns, Iterable<? extends NamespaceBinding> unregisteredNamespaces)
    {
        return new XmlSerializationMatcher(expectedText, ns, unregisteredNamespaces);
    }


    public static Matcher<Xml> serializesTo(String expectedText)
    {
        return new XmlSerializationMatcher(expectedText, new DefaultNamespaceRegistry(), emptyIterable());
    }


    @Override
    protected boolean matchesSafely(Xml item, Description mismatchDescription)
    {
        StringBuilder sb = new StringBuilder();
        StringBuilderSink sbs = new StringBuilderSink(sb);

        try
        {
            item.serialize(sbs, mNamespaceRegistry, mUnregisteredNamespaces);
        }
        catch (IOException e)
        {
            mismatchDescription.appendText(String.format("threw %s", e.getClass().getName()));
            return false;
        }

        if (!mXmlText.equals(sb.toString()))
        {
            mismatchDescription.appendText(String.format("serialized to '%s'", sb.toString()));
            return false;
        }
        return true;
    }


    @Override
    public void describeTo(Description description)
    {
        description.appendText(String.format("serializes to '%s'", mXmlText));
    }
}
