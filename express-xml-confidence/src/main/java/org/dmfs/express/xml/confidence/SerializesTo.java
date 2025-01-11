package org.dmfs.express.xml.confidence;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.Xml;
import org.dmfs.express.xml.namespaceregistry.DefaultNamespaceRegistry;
import org.dmfs.express.xml.sink.StringBuilderSink;
import org.dmfs.jems2.confidence.procedure.ProcedureThatAffects;
import org.dmfs.srcless.annotations.staticfactory.StaticFactories;
import org.saynotobugs.confidence.Quality;
import org.saynotobugs.confidence.quality.composite.Has;
import org.saynotobugs.confidence.quality.composite.QualityComposition;
import org.saynotobugs.confidence.quality.grammar.SoIt;

import static org.dmfs.jems2.iterable.EmptyIterable.emptyIterable;
import static org.saynotobugs.confidence.core.quality.Object.hasToString;


/**
 * A {@link Quality} of an {@link Xml} snippet.
 */
@StaticFactories("Xml")
public final class SerializesTo extends QualityComposition<Xml>
{
    public SerializesTo(CharSequence xmlText)
    {
        this(new DefaultNamespaceRegistry(), emptyIterable(), xmlText);
    }

    public SerializesTo(NamespaceRegistry namespaceRegistry, Iterable<? extends NamespaceBinding> unregisteredNamespaces, CharSequence xmlText)
    {
        this(namespaceRegistry, unregisteredNamespaces, hasToString(xmlText.toString()));
    }

    public SerializesTo(NamespaceRegistry namespaceRegistry, Iterable<? extends NamespaceBinding> unregisteredNamespaces, Quality<? super CharSequence> xmlTextQuality)
    {
        super(new Has<>(xml -> stringBuilder -> xml.serialize(new StringBuilderSink(stringBuilder), namespaceRegistry, unregisteredNamespaces),
            new ProcedureThatAffects<>(
                StringBuilder::new,
                new SoIt<>(xmlTextQuality))));
    }
}
