//}}}
//{{{ _init() method
protected void _init() {
    /* Text drag and drop */
    dragAndDrop = new JCheckBox(jEdit.getProperty("options.mouse.dragAndDrop"));
    dragAndDrop.setSelected(jEdit.getBooleanProperty("view.dragAndDrop"));
    addComponent(dragAndDrop);
    /* Non word character selection behavior */
    joinNonWordChars = new JCheckBox(jEdit.getProperty("options.mouse.joinNonWordChars"));
    joinNonWordChars.setSelected(jEdit.getBooleanProperty("view.joinNonWordChars"));
    addComponent(joinNonWordChars);
    /* Middle mouse button click pastes % register */
    middleMousePaste = new JCheckBox(jEdit.getProperty("options.mouse" + ".middleMousePaste"));
    middleMousePaste.setSelected(jEdit.getBooleanProperty("view.middleMousePaste"));
    addComponent(middleMousePaste);
    /*
		 * Pressing Ctrl while mouse actions makes them as if
		 * selection mode were rectangular mode
		 */
    ctrlForRectangularSelection = new JCheckBox(jEdit.getProperty("options.mouse.ctrlForRectangularSelection"));
    ctrlForRectangularSelection.setSelected(jEdit.getBooleanProperty("view.ctrlForRectangularSelection"));
    addComponent(ctrlForRectangularSelection);
    /* Gutter mouse actions */
    int c = clickActionKeys.length;
    String[] clickActionNames = new String[c];
    for (int i = 0; i < c; i++) {
        clickActionNames[i] = jEdit.getProperty("options.mouse.gutter." + clickActionKeys[i]);
    }
    c = clickModifierKeys.length;
    String[] clickModifierNames = new String[c];
    for (int i = 0; i < c; i++) {
        clickModifierNames[i] = jEdit.getProperty("options.mouse.gutter." + clickModifierKeys[i]);
    }
    gutterClickActions = new JComboBox[c];
    for (int i = 0; i < c; i++) {
        JComboBox<String> cb = new JComboBox<String>(clickActionNames);
        gutterClickActions[i] = cb;
        String val = jEdit.getProperty("view.gutter." + clickModifierKeys[i]);
        for (int j = 0; j < clickActionKeys.length; j++) {
            if (val.equals(clickActionKeys[j])) {
                cb.setSelectedIndex(j);
            }
        }
        addComponent(clickModifierNames[i], cb);
    }
}