package org.dmfs.express.xml.qualifiedname;

import org.dmfs.express.xml.QualifiedName;


/**
 * A trivial {@link QualifiedName}.
 */
public final class Qn implements QualifiedName
{
    private final String mNamespace;
    private final String mName;


    public Qn(String namespace, String name)
    {
        mNamespace = namespace;
        mName = name;
    }


    @Override
    public String namespace()
    {
        return mNamespace;
    }


    @Override
    public String name()
    {
        return mName;
    }
}
