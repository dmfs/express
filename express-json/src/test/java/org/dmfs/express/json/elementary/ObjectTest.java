package org.dmfs.express.json.elementary;

import org.dmfs.jems2.iterable.EmptyIterable;
import org.dmfs.jems2.iterable.Seq;
import org.dmfs.jems2.optional.Absent;
import org.dmfs.jems2.optional.Present;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.dmfs.express.json.confidence.Qualities.serializesTo;
import static org.saynotobugs.confidence.Assertion.assertThat;


public class ObjectTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new Object(), serializesTo("{}"));
        assertThat(new Object(new Member("a", 1)), serializesTo("{\"a\":1}"));
        assertThat(new Object(new Member("a", 1), new Member("x", "y")), serializesTo("{\"a\":1,\"x\":\"y\"}"));
        assertThat(new Object(new Member("a", new Object()), new Member("x", "y")), serializesTo("{\"a\":{},\"x\":\"y\"}"));
        assertThat(new Object(new Member("a", new Object(new Member("b", "q"))), new Member("x", new Array(1, 2, 3))),
            serializesTo("{\"a\":{\"b\":\"q\"},\"x\":[1,2,3]}"));
    }

    @Test
    public void testOptionalArgs()
    {
        assertThat(new Object(
                new EmptyIterable<>(),
                new EmptyIterable<>()),
            serializesTo("{}"));
        assertThat(new Object(
                new EmptyIterable<>(),
                new Absent<>(),
                new Absent<>()),
            serializesTo("{}"));
        assertThat(new Object(
                new EmptyIterable<>(),
                new Present<>(new Member("a", 1)),
                new Absent<>()),
            serializesTo("{\"a\":1}"));
        assertThat(new Object(
                new Seq<>(new Member("a", 1)),
                new Present<>(new Member("b", 2)),
                new Absent<>()),
            serializesTo("{\"a\":1,\"b\":2}"));
        assertThat(new Object(
                new Seq<>(
                    new Member("a", 1),
                    new Member("b", 2)),
                new Present<>(new Member("c", 3)),
                new Absent<>(),
                new Present<>(new Member("d", 4))),
            serializesTo("{\"a\":1,\"b\":2,\"c\":3,\"d\":4}"));
    }

    @Test
    public void testJvmOptionalArgs()
    {
        assertThat(new Object(
                new EmptyIterable<>(),
                Optional.empty(),
                Optional.empty()),
            serializesTo("{}"));
        assertThat(new Object(
                new EmptyIterable<>(),
                Optional.of(new Member("a", 1)),
                Optional.empty()),
            serializesTo("{\"a\":1}"));
        assertThat(new Object(
                new Seq<>(new Member("a", 1)),
                Optional.of(new Member("b", 2)),
                Optional.empty()),
            serializesTo("{\"a\":1,\"b\":2}"));
        assertThat(new Object(
                new Seq<>(
                    new Member("a", 1),
                    new Member("b", 2)),
                Optional.of(new Member("c", 3)),
                Optional.empty(),
                Optional.of(new Member("d", 4))),
            serializesTo("{\"a\":1,\"b\":2,\"c\":3,\"d\":4}"));
    }

}