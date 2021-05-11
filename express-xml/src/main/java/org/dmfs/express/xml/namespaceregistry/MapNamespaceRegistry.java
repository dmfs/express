package org.dmfs.express.xml.namespaceregistry;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.express.xml.NamespaceRegistry;
import org.dmfs.express.xml.namespacebinding.MapEntryNsBinding;
import org.dmfs.jems2.Optional;
import org.dmfs.jems2.Pair;
import org.dmfs.jems2.iterable.Mapped;
import org.dmfs.jems2.iterable.Sieved;
import org.dmfs.jems2.pair.ValuePair;

import java.util.Map;

import static org.dmfs.jems2.iterable.EmptyIterable.emptyIterable;


/**
 */
final class MapNamespaceRegistry implements NamespaceRegistry
{

    private final NamespaceRegistry mParent;
    private final Map<String, Optional<String>> mNamespaceMap;
    private final int mOffset;
    private final Pair<NamespaceRegistry, Iterable<NamespaceBinding>> mTransient = new ValuePair<>(this, emptyIterable());


    MapNamespaceRegistry(NamespaceRegistry parent, Map<String, Optional<String>> namespaceMap, int offset)
    {
        mParent = parent;
        mNamespaceMap = namespaceMap;
        mOffset = offset;
    }


    @Override
    public Pair<NamespaceRegistry, Iterable<NamespaceBinding>> withNamespaces(Iterable<String> namespaces)
    {
        Map<String, Optional<String>> namespaceMap = new NamespaceMapFunction(mOffset).value(new Sieved<>(
            ns -> !ns.isEmpty() && !mNamespaceMap.containsKey(ns) && !mParent.prefix(ns).isPresent(), namespaces));
        if (namespaceMap.isEmpty())
        {
            // return a transient version of this
            return mTransient;
        }

        return new ValuePair<>(
            new MapNamespaceRegistry(this, namespaceMap, mOffset + namespaceMap.size()),
            new Mapped<>(MapEntryNsBinding::new, namespaceMap.entrySet()));
    }


    @Override
    public Optional<String> prefix(String namespace)
    {
        Optional<String> prefix = mNamespaceMap.get(namespace);
        return prefix != null ? prefix : mParent.prefix(namespace);
    }
}
