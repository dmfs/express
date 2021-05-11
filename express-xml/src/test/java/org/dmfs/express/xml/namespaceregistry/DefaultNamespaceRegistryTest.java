package org.dmfs.express.xml.namespaceregistry;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.jems2.iterable.Seq;
import org.junit.Test;

import static org.dmfs.jems2.hamcrest.matchers.LambdaMatcher.having;
import static org.dmfs.jems2.hamcrest.matchers.iterable.IterableMatcher.iteratesTo;
import static org.dmfs.jems2.hamcrest.matchers.optional.PresentMatcher.present;
import static org.dmfs.jems2.hamcrest.matchers.pair.PairMatcher.pair;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link DefaultNamespaceRegistry}.
 *
 * @author Marten Gajda
 */
public class DefaultNamespaceRegistryTest
{
    @Test
    public void test()
    {
        assertThat(
            new DefaultNamespaceRegistry().prefix("http://www.w3.org/XML/1998/namespace"),
            is(present("xml"))
        );

        assertThat(
            new DefaultNamespaceRegistry().withNamespaces(new Seq<>("a")),
            is(pair(instanceOf(NamespaceRegistry.class), iteratesTo(allOf(
                having(NamespaceBinding::namespace, is("a")),
                having(NamespaceBinding::prefix, is("ns0"))
            )))));
    }
}