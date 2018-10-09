//{{{ MarkersMenuItem constructor
 MarkersMenuItem(Buffer buffer, int lineNo, char shortcut) {
    String text = buffer.getLineText(lineNo).trim();
    if (text.length() == 0)
        text = jEdit.getProperty("markers.blank-line");
    setText((lineNo + 1) + ": " + text);
    shortcutProp = "goto-marker.shortcut";
    MarkersMenuItem.this.shortcut = shortcut;
//}}}
}