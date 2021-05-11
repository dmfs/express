package org.dmfs.express.xml.hamcrest;

import org.dmfs.express.xml.QualifiedName;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import static org.hamcrest.Matchers.is;


/**
 * A Matcher for {@link QualifiedName}s.
 */
public final class QualifiedNameMatcher extends TypeSafeDiagnosingMatcher<QualifiedName>
{
    private final Matcher<String> mNsMatcher;
    private final Matcher<String> mNameMatcher;


    public static Matcher<QualifiedName> qualifiedName(String namespace, String name)
    {
        return qualifiedName(is(namespace), is(name));
    }


    public static Matcher<QualifiedName> qualifiedName(Matcher<String> nsMatcher, Matcher<String> nameMatcher)
    {
        return new QualifiedNameMatcher(nsMatcher, nameMatcher);
    }


    public QualifiedNameMatcher(Matcher<String> nsMatcher, Matcher<String> nameMatcher)
    {
        mNsMatcher = nsMatcher;
        mNameMatcher = nameMatcher;
    }


    @Override
    protected boolean matchesSafely(QualifiedName item, Description mismatchDescription)
    {
        if (!mNsMatcher.matches(item.namespace()))
        {
            mismatchDescription.appendText("Namespace ");
            mNsMatcher.describeMismatch(item.namespace(), mismatchDescription);
            return false;
        }
        if (!mNameMatcher.matches(item.name()))
        {
            mismatchDescription.appendText("Name ");
            mNameMatcher.describeMismatch(item.name(), mismatchDescription);
            return false;
        }
        return true;
    }


    @Override
    public void describeTo(Description description)
    {
        description
            .appendText("Namespace ").appendDescriptionOf(mNsMatcher)
            .appendText(" and name ").appendDescriptionOf(mNameMatcher);
    }
}
