//}}}
// {{{ resetButtons() methods
private void resetButtons() {
    KeymapManager keymapManager = jEdit.getKeymapManager();
    KeymapManager.State state = keymapManager.getKeymapState(selectedKeymap.toString());
    resetKeymap.setEnabled(state == KeymapManager.State.SystemModified);
    deleteKeymap.setEnabled(state == KeymapManager.State.User);
}