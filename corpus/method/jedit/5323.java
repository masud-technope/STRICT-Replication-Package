//}}}
//{{{ _save() method
@Override
protected void _save() {
    int index = lineSeparator.getSelectedIndex();
    String lineSep;
    if (index == 0)
        lineSep = "\n";
    else if (index == 1)
        lineSep = "\r\n";
    else if (index == 2)
        lineSep = "\r";
    else
        throw new InternalError();
    String oldLineSep = buffer.getStringProperty(JEditBuffer.LINESEP);
    if (oldLineSep == null)
        oldLineSep = System.getProperty("line.separator");
    if (!oldLineSep.equals(lineSep)) {
        buffer.setStringProperty(JEditBuffer.LINESEP, lineSep);
        buffer.setDirty(true);
    }
    String encoding = (String) this.encoding.getSelectedItem();
    String oldEncoding = buffer.getStringProperty(JEditBuffer.ENCODING);
    if (!oldEncoding.equals(encoding)) {
        buffer.setStringProperty(JEditBuffer.ENCODING, encoding);
        buffer.setDirty(true);
        // Disable auto-detect because user explicitly
        // specify an encoding.
        buffer.setBooleanProperty(Buffer.ENCODING_AUTODETECT, false);
    }
    boolean gzippedValue = gzipped.isSelected();
    boolean oldGzipped = buffer.getBooleanProperty(Buffer.GZIPPED);
    if (gzippedValue != oldGzipped) {
        buffer.setBooleanProperty(Buffer.GZIPPED, gzippedValue);
        buffer.setDirty(true);
    }
    buffer.setStringProperty("folding", (String) folding.getSelectedItem());
    buffer.setStringProperty("wrap", (String) wrap.getSelectedItem());
    try {
        buffer.setProperty("maxLineLen", Integer.valueOf(maxLineLen.getSelectedItem().toString()));
    } catch (NumberFormatException nf) {
    }
    try {
        buffer.setProperty("tabSize", Integer.valueOf(tabSize.getSelectedItem().toString()));
    } catch (NumberFormatException nf) {
    }
    try {
        buffer.setProperty("indentSize", Integer.valueOf(indentSize.getSelectedItem().toString()));
    } catch (NumberFormatException nf) {
    }
    buffer.setBooleanProperty("noTabs", noTabs.isSelected());
    buffer.setBooleanProperty("elasticTabstops", elasticTabstops.isSelected());
    buffer.setStringProperty("autoIndent", (String) autoIndent.getSelectedItem());
    // requires propertiesChanged() call afterwards
    buffer.setBooleanProperty("locked", locked.isSelected());
    index = mode.getSelectedIndex();
    // NOTE: setMode() makes implicit call of propertiesChanged()
    buffer.setMode(modes[index]);
    switch(checkModStatus.getSelectedIndex()) {
        case 0:
            buffer.setAutoReloadDialog(false);
            buffer.setAutoReload(false);
            break;
        case 1:
            buffer.setAutoReloadDialog(true);
            buffer.setAutoReload(false);
            break;
        case 2:
            buffer.setAutoReloadDialog(true);
            buffer.setAutoReload(true);
            break;
        case 3:
            buffer.setAutoReloadDialog(false);
            buffer.setAutoReload(true);
            break;
    }
}