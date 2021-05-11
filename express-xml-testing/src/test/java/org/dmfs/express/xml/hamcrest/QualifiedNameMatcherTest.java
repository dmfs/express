package org.dmfs.express.xml.hamcrest;

import org.dmfs.express.xml.QualifiedName;
import org.junit.Test;

import static org.dmfs.express.xml.hamcrest.QualifiedNameMatcher.qualifiedName;
import static org.dmfs.jems2.hamcrest.matchers.matcher.MatcherMatcher.*;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link QualifiedNameMatcher}.
 *
 * @author Marten Gajda
 */
public class QualifiedNameMatcherTest
{
    @Test
    public void test()
    {
        assertThat(qualifiedName("a", "b"), matches(new QualifiedName()
        {
            @Override
            public String namespace()
            {
                return "a";
            }


            @Override
            public String name()
            {
                return "b";
            }
        }));

        assertThat(qualifiedName("a", "b"), mismatches(new QualifiedName()
        {
            @Override
            public String namespace()
            {
                return "d";
            }


            @Override
            public String name()
            {
                return "b";
            }
        }, "Namespace was \"d\""));

        assertThat(qualifiedName("a", "b"), mismatches(new QualifiedName()
        {
            @Override
            public String namespace()
            {
                return "a";
            }


            @Override
            public String name()
            {
                return "c";
            }
        }, "Name was \"c\""));

        assertThat(qualifiedName("a", "b"), describesAs("Namespace is \"a\" and name is \"b\""));
    }
}