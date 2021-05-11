package org.dmfs.express.xml.attribute;

import org.dmfs.express.xml.Attribute;
import org.dmfs.express.xml.QualifiedName;
import org.dmfs.jems2.Single;


/**
 * A simple {@link Attribute} having a {@link QualifiedName} and a {@link String} value.
 */
public final class Attr implements Attribute
{
    private final QualifiedName mName;
    private final Single<String> mValue;


    /**
     * Create an {@link Attribute} with the given {@link QualifiedName} and {@link String} value.
     */
    public Attr(QualifiedName name, String value)
    {
        this(name, () -> value);
    }


    /**
     * Create an {@link Attribute} with the given {@link QualifiedName} and {@link String} value.
     */
    public Attr(QualifiedName name, Single<String> value)
    {
        mName = name;
        mValue = value;
    }


    @Override
    public QualifiedName name()
    {
        return mName;
    }


    @Override
    public String value()
    {
        return mValue.value();
    }
}
