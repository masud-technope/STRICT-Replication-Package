@Override
public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == selectModel) {
        ShortcutsModel newModel = (ShortcutsModel) selectModel.getSelectedItem();
        if (filteredModel.getDelegated() != newModel) {
            jEdit.setIntegerProperty("options.shortcuts.select.index", selectModel.getSelectedIndex());
            filteredModel.setDelegated(newModel);
            setFilter();
        }
    } else if (evt.getSource() == keymaps) {
        String selectedKeymapName = (String) keymaps.getSelectedItem();
        KeymapManager keymapManager = jEdit.getKeymapManager();
        selectedKeymap = keymapManager.getKeymap(selectedKeymapName);
        resetButtons();
        reloadModels();
    } else if (evt.getSource() == duplicateKeymap) {
        String newName = JOptionPane.showInputDialog(ShortcutsOptionPane.this, jEdit.getProperty("options.shortcuts.duplicatekeymap.dialog.label"), jEdit.getProperty("options.shortcuts.duplicatekeymap.dialog.title"), JOptionPane.QUESTION_MESSAGE);
        if (newName == null) {
            return;
        }
        newName = newName.replace(' ', '_');
        KeymapManager manager = jEdit.getKeymapManager();
        Collection<String> keymapNames = manager.getKeymapNames();
        while (keymapNames.contains(newName)) {
            newName = JOptionPane.showInputDialog(ShortcutsOptionPane.this, jEdit.getProperty("options.shortcuts.duplicatekeymap.keymapalreadyexists.label"), jEdit.getProperty("options.shortcuts.duplicatekeymap.dialog.title"), JOptionPane.QUESTION_MESSAGE);
            if (newName == null) {
                return;
            }
            newName = newName.replace(' ', '_');
        }
        if (manager.copyKeymap(selectedKeymap.toString(), newName)) {
            KeymapsModel model = (KeymapsModel) keymaps.getModel();
            model.reset();
            keymaps.setSelectedItem(newName);
        }
    } else if (evt.getSource() == resetKeymap) {
        int ret = JOptionPane.showConfirmDialog(ShortcutsOptionPane.this, jEdit.getProperty("options.shortcuts.resetkeymap.dialog.label"), jEdit.getProperty("options.shortcuts.resetkeymap.dialog.title"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ret == JOptionPane.YES_OPTION) {
            String name = selectedKeymap.toString();
            KeymapManager manager = jEdit.getKeymapManager();
            manager.resetKeymap(name);
            selectedKeymap = manager.getKeymap(name);
            resetButtons();
            reloadModels();
        }
    } else if (evt.getSource() == deleteKeymap) {
        int ret = JOptionPane.showConfirmDialog(ShortcutsOptionPane.this, jEdit.getProperty("options.shortcuts.deletekeymap.dialog.label"), jEdit.getProperty("options.shortcuts.deletekeymap.dialog.title"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ret == JOptionPane.YES_OPTION) {
            KeymapManager manager = jEdit.getKeymapManager();
            KeymapManager.State keymapState = manager.getKeymapState(selectedKeymap.toString());
            if (keymapState == KeymapManager.State.User) {
                manager.deleteUserKeymap(selectedKeymap.toString());
                KeymapsModel model = (KeymapsModel) keymaps.getModel();
                model.reset();
            }
        }
    }
}