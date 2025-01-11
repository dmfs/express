package org.dmfs.express.xml.confidence;

import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.AllOf;
import org.saynotobugs.confidence.quality.composite.Has;
import org.saynotobugs.confidence.quality.composite.QualityComposition;
import org.saynotobugs.confidence.quality.grammar.Is;


/**
 * A Quality of {@link QualifiedName}s.
 */
@StaticFactories("Xml")
public final class QualifiedName extends QualityComposition<org.dmfs.express.xml.QualifiedName>
{
    public QualifiedName(String ns, String name)
    {
        this(new Is<>(ns), new Is<>(name));
    }


    public QualifiedName(Quality<? super String> nsQuality, Quality<? super String> nameQuality)
    {
        super(new AllOf<>(
            new Has<>("namespace", org.dmfs.express.xml.QualifiedName::namespace, nsQuality),
            new Has<>("name", org.dmfs.express.xml.QualifiedName::name, nameQuality)
        ));
    }
}
