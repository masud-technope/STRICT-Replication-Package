//}}}
//{{{ setCloseButtonVisibility() method
private void setCloseButtonVisibility() {
    if (isRemovable) {
        if (close == null) {
            close = new RolloverButton(GUIUtilities.loadIcon("closebox.gif"));
            close.addActionListener(new ActionHandler());
            close.setToolTipText(jEdit.getProperty("view.search.close-tooltip"));
        }
        add(close);
    } else if (close != null)
        remove(close);
}