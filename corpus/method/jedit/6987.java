//}}}
//{{{ initBuffer() method
/**
	 * Reinitializes the buffer by reading the properties from the property manager
	 */
private void initBuffer() {
    String[] bufferProperties = { "lineSeparator", "encodingAutodetect", "tabSize", "indentSize", "noTabs", "defaultMode", "undoCount", "wrap", "maxLineLen", "wordBreakChars", "noWordSep", "camelCasedWords", "folding", "collapseFolds" };
    for (String bufferProperty : bufferProperties) {
        String value = getProperty("buffer." + bufferProperty);
        if (value == null)
            buffer.unsetProperty(bufferProperty);
        else
            buffer.setProperty(bufferProperty, value);
    }
    buffer.propertiesChanged();
}