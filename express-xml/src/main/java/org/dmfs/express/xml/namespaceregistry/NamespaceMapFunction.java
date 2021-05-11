package org.dmfs.express.xml.namespaceregistry;

import org.dmfs.jems2.Function;
import org.dmfs.jems2.Optional;
import org.dmfs.jems2.optional.Present;

import java.util.HashMap;
import java.util.Map;


/**
 *
 */
final class NamespaceMapFunction implements Function<Iterable<String>, Map<String, Optional<String>>>
{

    private final int mOffset;


    public NamespaceMapFunction(int offset)
    {
        mOffset = offset;
    }


    @Override
    public Map<String, Optional<String>> value(Iterable<String> namespaces)
    {
        int size = mOffset;
        Map<String, Optional<String>> namespaceMap = new HashMap<>();
        for (String namespace : namespaces)
        {
            if (!namespaceMap.containsKey(namespace))
            {
                namespaceMap.put(namespace, new Present<>("ns" + size));
                size += 1;
            }
        }
        return namespaceMap;
    }
}
