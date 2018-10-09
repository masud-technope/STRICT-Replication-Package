//}}}
//{{{ invertSelection() method
void invertSelection() {
    Selection[] newSelection = new Selection[selection.size() + 1];
    int lastOffset = 0;
    for (int i = 0; i < selection.size(); i++) {
        Selection s = selection.get(i);
        newSelection[i] = new Selection.Range(lastOffset, s.getStart());
        lastOffset = s.getEnd();
    }
    newSelection[selection.size()] = new Selection.Range(lastOffset, textArea.getBufferLength());
    setSelection(newSelection);
}