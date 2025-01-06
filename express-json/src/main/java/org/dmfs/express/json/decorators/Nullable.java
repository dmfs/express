package org.dmfs.express.json.decorators;

import org.dmfs.express.json.JsonSink;
import org.dmfs.express.json.JsonValue;
import org.dmfs.express.json.elementary.Boolean;
import org.dmfs.express.json.elementary.Null;
import org.dmfs.express.json.elementary.Number;
import org.dmfs.express.json.elementary.String;
import org.dmfs.jems2.Optional;
import org.dmfs.jems2.Single;
import org.dmfs.jems2.optional.Mapped;
import org.dmfs.jems2.optional.NullSafe;
import org.dmfs.jems2.single.Backed;

import java.io.IOException;


/**
 * A {@link JsonValue} value which can be {@code null}.
 */
public final class Nullable implements JsonValue
{
    private final Single<JsonValue> mDelegate;


    public Nullable(@org.eclipse.jdt.annotation.Nullable CharSequence string)
    {
        this(new Mapped<>(String::new, new NullSafe<>(string)));
    }


    public Nullable(java.lang.Number number)
    {
        this(new Mapped<>(Number::new, new NullSafe<>(number)));
    }


    public Nullable(java.lang.Boolean bool)
    {
        this(new Mapped<>(Boolean::new, new NullSafe<>(bool)));
    }


    public Nullable(JsonValue jsonValue)
    {
        this(new NullSafe<>(jsonValue));
    }


    private Nullable(Optional<JsonValue> delegate)
    {
        mDelegate = new Backed<>(delegate, new Null());
    }


    @Override
    public void serialize(JsonSink jsonSink) throws IOException
    {
        mDelegate.value().serialize(jsonSink);
    }
}
