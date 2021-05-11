package org.dmfs.express.xml.namespacebinding;

import org.dmfs.express.xml.NamespaceBinding;
import org.dmfs.jems2.Optional;

import java.util.Map;


/**
 * A {@link NamespaceBinding} based on a {@link Map.Entry}.
 */
public final class MapEntryNsBinding implements NamespaceBinding
{
    private final Map.Entry<String, Optional<String>> mNamespaceMapEntry;


    public MapEntryNsBinding(Map.Entry<String, Optional<String>> namespaceMapEntry)
    {
        mNamespaceMapEntry = namespaceMapEntry;
    }


    @Override
    public String prefix()
    {
        return mNamespaceMapEntry.getValue().value();
    }


    @Override
    public String namespace()
    {
        return mNamespaceMapEntry.getKey();
    }
}
