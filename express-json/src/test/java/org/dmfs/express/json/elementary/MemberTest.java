package org.dmfs.express.json.elementary;

import org.dmfs.express.json.Jsonable;
import org.junit.Test;

import static org.dmfs.express.json.hamcrest.JsonSerializationMatcher.serializesTo;
import static org.dmfs.jems2.hamcrest.matchers.pair.PairMatcher.pair;
import static org.junit.Assert.assertThat;


/**
 * Unit test for {@link Member}.
 *
 * @author Marten Gajda
 */
public class MemberTest
{
    @Test
    public void test() throws Exception
    {
        assertThat(new Member("abc", (Jsonable) Object::new), pair(serializesTo("\"abc\""), serializesTo("{}")));
        assertThat(new Member("abc", "123"), pair(serializesTo("\"abc\""), serializesTo("\"123\"")));
        assertThat(new Member("abc", 123), pair(serializesTo("\"abc\""), serializesTo("123")));
        assertThat(new Member("abc", true), pair(serializesTo("\"abc\""), serializesTo("true")));
        assertThat(new Member("abc", new String("123")), pair(serializesTo("\"abc\""), serializesTo("\"123\"")));
        assertThat(new Member(new String("abc"), new String("123")), pair(serializesTo("\"abc\""), serializesTo("\"123\"")));
    }
}