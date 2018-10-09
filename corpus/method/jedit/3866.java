//}}}
//{{{ showClipText() method
private void showClipText() {
    java.util.List selected = clips.getSelectedValuesList();
    if (selected == null || selected.isEmpty()) {
        clipText.setText("");
    } else {
        String text = getSelectedClipText();
        int maxPreviewLength = jEdit.getIntegerProperty("paste-from-list.max-preview-length", 100000);
        if (text.length() > maxPreviewLength) {
            StringBuilder showText = new StringBuilder(text.substring(0, maxPreviewLength));
            showText.append('<').append((text.length() - maxPreviewLength)).append(" more bytes>");
            clipText.setText(showText.toString());
        } else {
            clipText.setText(text);
        }
    }
    clipText.setCaretPosition(0);
}