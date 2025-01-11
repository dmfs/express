package org.dmfs.express.xml.namespaceregistry;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.jems2.Pair;
import org.dmfs.jems2.iterable.Seq;
import org.junit.jupiter.api.Test;

import static org.dmfs.jems2.confidence.Jems2.present;
import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Composite.allOf;
import static org.saynotobugs.confidence.core.quality.Composite.has;
import static org.saynotobugs.confidence.core.quality.Grammar.is;
import static org.saynotobugs.confidence.core.quality.Iterable.iterates;
import static org.saynotobugs.confidence.core.quality.Object.instanceOf;


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
            is(allOf(
                has(Pair::left,
                    instanceOf(NamespaceRegistry.class)),
                has(Pair::right,
                    iterates(allOf(
                        has(NamespaceBinding::namespace, is("a")),
                        has(NamespaceBinding::prefix, is("ns0"))))))));
    }
}