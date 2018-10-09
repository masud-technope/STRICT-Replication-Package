//}}}
// returns a temporary buffer containing only the lines in the current selection.
// This also stores the line numbers of the selected lines as a buffer property
// so they can be used for printing and print preview.
private static Buffer getSelectionBuffer(View view, Buffer buffer) {
    int[] selectedLines = view.getTextArea().getSelectedLines();
    String path = buffer.getPath();
    String parent = path.substring(0, path.lastIndexOf(System.getProperty("file.separator")));
    Buffer temp = jEdit.openTemporary(view, parent, path + ".prn", true);
    temp.setMode(buffer.getMode());
    for (int i : selectedLines) {
        String line = buffer.getLineText(i) + '\n';
        temp.insert(temp.getLength(), line);
    }
    // save the line numbers of the selected lines so they can be used for 
    // printing and print preview
    temp.setProperty("printingLineNumbers", selectedLines);
    return temp;
}