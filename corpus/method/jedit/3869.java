//}}}
//{{{ cleanup()
private void cleanup() {
    // Remove the reference to the JList from the history model so that the
    // list doesn't keep getting updated after the dialog is gone
    String[] nothing = {};
    clips.setListData(nothing);
    dispose();
}