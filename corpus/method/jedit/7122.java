//}}}
//{{{ insertTab() method
private void insertTab() {
    int tabSize = buffer.getTabSize();
    if (buffer.getBooleanProperty("noTabs")) {
        int lineStart = getLineStartOffset(caretLine);
        String line = getText(lineStart, caret - lineStart);
        int pos = 0;
        for (int i = 0; i < line.length(); i++) {
            switch(line.charAt(pos)) {
                case '\t':
                    pos = 0;
                    break;
                default:
                    if (++pos >= tabSize)
                        pos = 0;
                    break;
            }
        }
        replaceSelection(StandardUtilities.createWhiteSpace(tabSize - pos, 0));
    } else
        replaceSelection("\t");
}