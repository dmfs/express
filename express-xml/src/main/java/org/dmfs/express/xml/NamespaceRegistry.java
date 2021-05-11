package org.dmfs.express.xml;

import org.dmfs.jems2.Optional;
import org.dmfs.jems2.Pair;


/**
 * The registry for XML namespaces.
 */
public interface NamespaceRegistry
{

    /**
     * Creates a new {@link NamespaceRegistry} with a mapping for the given namespaces and an {@link Iterable} of the prefix-namespace pairs which were added.
     */
    Pair<NamespaceRegistry, Iterable<NamespaceBinding>> withNamespaces(Iterable<String> namespaces);

    /**
     * Returns the prefix of the given namespace, if present.
     */
    Optional<String> prefix(String namespace);
}
