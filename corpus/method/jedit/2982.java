public void statusChanged(org.gjt.sp.jedit.textarea.TextArea textArea, int flag, boolean value) {
    StatusBar status = view.getStatus();
    if (status == null)
        return;
    switch(flag) {
        case OVERWRITE_CHANGED:
            status.setMessageAndClear(jEdit.getProperty("view.status.overwrite-changed", new Integer[] { value ? 1 : 0 }));
            break;
        case MULTI_SELECT_CHANGED:
            status.setMessageAndClear(jEdit.getProperty("view.status.multi-changed", new Integer[] { value ? 1 : 0 }));
            break;
        case RECT_SELECT_CHANGED:
            status.setMessageAndClear(jEdit.getProperty("view.status.rect-select-changed", new Integer[] { value ? 1 : 0 }));
            break;
    }
    status.updateMiscStatus();
}