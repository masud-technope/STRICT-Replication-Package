//}}}
//{{{ insertRegister
private void insertRegister() {
    String o = registerList.getSelectedValue();
    if (o == null || o.length() > 1)
        return;
    Registers.Register reg = Registers.getRegister(o.charAt(0));
    view.getTextArea().setSelectedText(reg.toString());
    // can't use requestFocusInWindow() here, otherwise we'll stay
    // in RegisterViewer when it is a floating window
    view.getTextArea().requestFocus();
    // close the window if we are floating
    DockableWindowManager dm = view.getDockableWindowManager();
    if (!dm.isDockableWindowDocked("view-registers")) {
        dm.hideDockableWindow("view-registers");
    }
}