package org.dmfs.express.xml;

import java.io.IOException;


/**
 * @author Marten Gajda
 */
public interface XmlSink
{
    XmlSink writeText(String text) throws IOException;
}
