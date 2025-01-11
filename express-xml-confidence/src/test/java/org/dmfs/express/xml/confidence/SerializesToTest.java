package org.dmfs.express.xml.confidence;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.saynotobugs.confidence.Assertion.assertThat;
import static org.saynotobugs.confidence.core.quality.Composite.allOf;
import static org.saynotobugs.confidence.test.quality.Quality.*;

class SerializesToTest
{
    @Test
    void test()
    {
        assertThat(new SerializesTo("abc"),
            allOf(
                passes((xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("abc")),
                fails((xmlSink, namespaceRegistry, unregisteredPrefixes) -> xmlSink.writeText("xyz")),
                fails((xmlSink, namespaceRegistry, unregisteredPrefixes) -> {throw new IOException("Yikes!");}),
                hasDescription("Procedure that affects \"\" so it has toString() \"abc\" after successful execution")
            ));
    }

}