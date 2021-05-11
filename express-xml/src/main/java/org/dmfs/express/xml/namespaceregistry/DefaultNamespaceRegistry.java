package org.dmfs.express.xml.namespaceregistry;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.namespacebinding.MapEntryNsBinding;
import org.dmfs.express.xml.qualifiedname.XmlName;
import org.dmfs.express.xml.qualifiedname.XmlNsName;
import org.dmfs.jems2.Optional;
import org.dmfs.jems2.Pair;
import org.dmfs.jems2.iterable.Mapped;
import org.dmfs.jems2.iterable.Sieved;
import org.dmfs.jems2.optional.Present;
import org.dmfs.jems2.pair.ValuePair;

import java.util.Map;

import static org.dmfs.jems2.iterable.EmptyIterable.emptyIterable;
import static org.dmfs.jems2.optional.Absent.absent;


/**
 * A {@link NamespaceRegistry} which contains only the default namespaces {@code xmlns} and {@code xml}.
 */
public final class DefaultNamespaceRegistry implements NamespaceRegistry
{
    // These are the standard namespace prefixes
    private final static Optional<String> XMLNS = new Present<>("xmlns");
    private final static Optional<String> XML = new Present<>("xml");


    @Override
    public Pair<NamespaceRegistry, Iterable<NamespaceBinding>> withNamespaces(Iterable<String> namespaces)
    {
        Map<String, Optional<String>> namespaceMap = new NamespaceMapFunction(0).value(new Sieved<>(
            ns -> !ns.isEmpty() && !prefix(ns).isPresent(), namespaces));
        if (namespaceMap.isEmpty())
        {
            return new ValuePair<>(this, emptyIterable());
        }
        return new ValuePair<>(
            new MapNamespaceRegistry(this, namespaceMap, namespaceMap.size()),
            new Mapped<>(MapEntryNsBinding::new, namespaceMap.entrySet()));
    }


    @Override
    public Optional<String> prefix(String namespace)
    {
        switch (namespace)
        {
            case XmlNsName.NAMESPACE:
                return XMLNS;
            case XmlName.NAMESPACE:
                return XML;
            default:
                return absent();
        }
    }
}
