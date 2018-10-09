//}}}
//{{{ exportDone() method
@Override
protected void exportDone(JComponent c, Transferable t, int action) {
    Log.log(Log.DEBUG, this, "Export done");
    JEditTextArea textArea = (JEditTextArea) c;
    try {
        // This happens if importData returns false. For example if you drop into the Selection
        if (action == NONE) {
            Log.log(Log.DEBUG, this, "Export impossible");
            return;
        }
        if (t == null) {
            Log.log(Log.DEBUG, this, "=> Null transferrable");
            textArea.selectNone();
        } else if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            Log.log(Log.DEBUG, this, "=> String");
            if (sameTextArea) {
                if (action == MOVE) {
                    textArea.setSelectedText(null, false);
                    insertPos += insertOffset;
                }
                try {
                    String str = (String) t.getTransferData(DataFlavor.stringFlavor);
                    textArea.getBuffer().insert(insertPos, str);
                    textArea.setSelection(new Selection.Range(insertPos, insertPos + str.length()));
                } catch (Exception e) {
                    Log.log(Log.DEBUG, this, "exportDone in sameTextArea");
                    Log.log(Log.DEBUG, this, e);
                }
            } else {
                if (action == MOVE)
                    textArea.setSelectedText(null, false);
                else
                    textArea.selectNone();
            }
        }
    } finally {
        if (compoundEdit) {
            compoundEdit = false;
            textArea.getBuffer().endCompoundEdit();
        }
    }
    dragSource = null;
}