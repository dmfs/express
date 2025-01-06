package org.dmfs.express.json.confidence;

import org.dmfs.express.json.JsonValue;
import org.dmfs.jems2.FragileProcedure;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.QualityComposition;

import static org.dmfs.jems2.confidence.Jems2.procedureThatAffects;
import static org.saynotobugs.confidence.core.quality.Composite.has;
import static org.saynotobugs.confidence.core.quality.Grammar.soIt;
import static org.saynotobugs.confidence.core.quality.Object.hasToString;


/**
 * A {@link Quality} which checks the serialization of a {@link JsonValue}.
 * <p>
 * TODO: move to separate module
 */
@StaticFactories("Qualities")
public final class SerializesTo extends QualityComposition<JsonValue>
{
    public SerializesTo(String jsonText)
    {
        super(has(
            value -> (FragileProcedure<StringBuilder, Exception>) stringBuilder -> value.serialize(stringBuilder::append),
            procedureThatAffects(
                StringBuilder::new,
                soIt(hasToString(jsonText))
            )
        ));
    }
}
