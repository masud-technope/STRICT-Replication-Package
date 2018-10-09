//}}}
//{{{ parseXML() method
/**
	 * Convenience method for parsing an XML file. This method will
	 * wrap the resource in an InputSource and set the source's
	 * systemId to "jedit.jar" (so the source should be able to
	 * handle any external entities by itself).
	 *
	 * <p>SAX Errors are caught and are not propagated to the caller;
	 * instead, an error message is printed to jEdit's activity
	 * log. So, if you need custom error handling, <b>do not use
	 * this method</b>.
	 *
	 * <p>The given stream is closed before the method returns,
	 * regardless whether there were errors or not.</p>
	 *
	 * @return true if any error occured during parsing, false if success.
	 */
public static boolean parseXML(InputStream in, DefaultHandler handler) throws IOException {
    try {
        XMLReader parser = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        InputSource isrc = new InputSource(new BufferedInputStream(in));
        isrc.setSystemId("jedit.jar");
        parser.setContentHandler(handler);
        parser.setDTDHandler(handler);
        parser.setEntityResolver(handler);
        parser.setErrorHandler(handler);
        parser.parse(isrc);
    } catch (SAXParseException se) {
        int line = se.getLineNumber();
        Log.log(Log.ERROR, XMLUtilities.class, "while parsing from " + in + ": SAXParseException: line " + line + ": ", se);
        return true;
    } catch (SAXException | ParserConfigurationException e) {
        Log.log(Log.ERROR, XMLUtilities.class, e);
        return true;
    } finally {
        IOUtilities.closeQuietly((Closeable) in);
    }
    return false;
}