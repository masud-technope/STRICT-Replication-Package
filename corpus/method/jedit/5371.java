//}}}
//{{{ _save() method
@Override
protected void _save() {
    String lineSep = null;
    switch(lineSeparator.getSelectedIndex()) {
        case 0:
            lineSep = "\n";
            break;
        case 1:
            lineSep = "\r\n";
            break;
        case 2:
            lineSep = "\r";
            break;
    }
    jEdit.setProperty("buffer." + JEditBuffer.LINESEP, lineSep);
    jEdit.setProperty("buffer." + JEditBuffer.ENCODING, (String) defaultEncoding.getSelectedItem());
    jEdit.setBooleanProperty("buffer.encodingAutodetect", encodingAutodetect.isSelected());
    jEdit.setProperty("encodingDetectors", encodingDetectors.getText());
    jEdit.setProperty("fallbackEncodings", fallbackEncodings.getText());
    Iterator<String> available = pingPongList.getLeftDataIterator();
    while (available.hasNext()) {
        String encoding = available.next();
        setBooleanProperty("encoding.opt-out." + encoding, true);
    }
    Iterator<String> selected = pingPongList.getRightDataIterator();
    while (selected.hasNext()) {
        String encoding = selected.next();
        unsetProperty("encoding.opt-out." + encoding);
    }
}