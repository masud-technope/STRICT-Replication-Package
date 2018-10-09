//}}}
//{{{ showBuffer() method
private EditPane showBuffer(Buffer buffer, boolean focus) {
    if (editPane.getBuffer() == buffer && editPane.getTextArea().getVisibleLines() > 1) {
        if (focus)
            editPane.focusOnTextArea();
        return editPane;
    }
    EditPane[] editPanes = getEditPanes();
    for (EditPane ep : editPanes) {
        if (ep.getBuffer() == buffer && /* ignore zero-height splits, etc */
        ep.getTextArea().getVisibleLines() > 1) {
            setEditPane(ep);
            if (focus)
                ep.focusOnTextArea();
            return ep;
        }
    }
    editPane.setBuffer(buffer, focus);
    return editPane;
}