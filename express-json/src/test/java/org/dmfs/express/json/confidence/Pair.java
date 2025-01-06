package org.dmfs.express.json.confidence;

import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.QualityComposition;

import static org.saynotobugs.confidence.core.quality.Composite.allOf;
import static org.saynotobugs.confidence.core.quality.Composite.has;


// TODO: this should be in jems2-confidence
@StaticFactories("Qualities")
public final class Pair<Left, Right> extends QualityComposition<org.dmfs.jems2.Pair<Left, Right>>
{
    public Pair(Quality<? super Left> leftDelegate, Quality<? super Right> rightDelegate)
    {
        super(allOf(
            has(org.dmfs.jems2.Pair::left, leftDelegate),
            has(org.dmfs.jems2.Pair::right, rightDelegate)
        ));
    }
}
