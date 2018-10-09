//}}}
//{{{ _init() method
@Override
protected void _init() {
    /* Line separator */
    String[] lineSeps = { jEdit.getProperty("lineSep.unix"), jEdit.getProperty("lineSep.windows"), jEdit.getProperty("lineSep.mac") };
    lineSeparator = new JComboBox<String>(lineSeps);
    String lineSep = jEdit.getProperty("buffer." + JEditBuffer.LINESEP, System.getProperty("line.separator"));
    if ("\n".equals(lineSep))
        lineSeparator.setSelectedIndex(0);
    else if ("\r\n".equals(lineSep))
        lineSeparator.setSelectedIndex(1);
    else if ("\r".equals(lineSep))
        lineSeparator.setSelectedIndex(2);
    addComponent(jEdit.getProperty("options.general.lineSeparator"), lineSeparator);
    // Default file encoding
    String[] encodings = getEncodings(true);
    sort(encodings, new StandardUtilities.StringCompare<String>(true));
    defaultEncoding = new JComboBox<String>(encodings);
    defaultEncoding.setEditable(true);
    defaultEncoding.setSelectedItem(jEdit.getProperty("buffer." + JEditBuffer.ENCODING, System.getProperty("file.encoding")));
    addComponent(jEdit.getProperty("options.general.encoding"), defaultEncoding);
    // Auto detect encoding
    encodingAutodetect = new JCheckBox(jEdit.getProperty("options.general.encodingAutodetect"));
    encodingAutodetect.setSelected(jEdit.getBooleanProperty("buffer.encodingAutodetect"));
    addComponent(encodingAutodetect, BOTH);
    // Encoding detectors
    encodingDetectors = new JTextField(jEdit.getProperty("encodingDetectors", ""));
    addComponent(jEdit.getProperty("options.general.encodingDetectors"), encodingDetectors);
    // Fallback Encodings
    fallbackEncodings = new JTextField(jEdit.getProperty("fallbackEncodings", ""));
    fallbackEncodings.setToolTipText(jEdit.getProperty("options.general.fallbackEncodings.tooltip"));
    addComponent(jEdit.getProperty("options.general.fallbackEncodings"), fallbackEncodings);
    // Encodings to display
    encodings = getEncodings(false);
    sort(encodings, new StandardUtilities.StringCompare<String>(true));
    List<String> availableEncodings = new ArrayList<String>();
    List<String> selectedEncodings = new ArrayList<String>();
    for (String encoding : encodings) {
        boolean selected = !getBooleanProperty("encoding.opt-out." + encoding, false);
        if (selected)
            selectedEncodings.add(encoding);
        else
            availableEncodings.add(encoding);
    }
    pingPongList = new PingPongList<String>(availableEncodings, selectedEncodings);
    pingPongList.setLeftTitle(getProperty("options.encodings.available"));
    pingPongList.setRightTitle(getProperty("options.encodings.selected"));
    pingPongList.setLeftTooltip(getProperty("options.encodings.available.tooltip"));
    pingPongList.setRightTooltip(getProperty("options.encodings.selected.tooltip"));
    addComponent(pingPongList, BOTH);
}