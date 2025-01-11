package org.dmfs.express.xml.confidence;

import org.junit.jupiter.api.Test;

import static org.dmfs.jems2.mockito.Mock.*;
import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Composite.allOf;
import static org.saynotobugs.confidence.test.quality.Quality.*;

class QualifiedNameTest
{
    @Test
    void test()
    {
        assertThat(new QualifiedName("foo", "bar"),
            allOf(
                passes(mock(org.dmfs.express.xml.QualifiedName.class,
                    with(org.dmfs.express.xml.QualifiedName::namespace, returning("foo")),
                    with(org.dmfs.express.xml.QualifiedName::name, returning("bar")))),
                fails(mock(org.dmfs.express.xml.QualifiedName.class,
                    with(org.dmfs.express.xml.QualifiedName::namespace, returning("baz")),
                    with(org.dmfs.express.xml.QualifiedName::name, returning("bar")))),
                fails(mock(org.dmfs.express.xml.QualifiedName.class,
                    with(org.dmfs.express.xml.QualifiedName::namespace, returning("foo")),
                    with(org.dmfs.express.xml.QualifiedName::name, returning("baz")))),
                hasDescription("all of\n  0: has namespace is \"foo\"\n  1: has name is \"bar\"")
            ));
    }

}