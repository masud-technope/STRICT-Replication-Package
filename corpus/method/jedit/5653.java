@Override
public void actionPerformed(ActionEvent evt) {
    switch(command) {
        case TAB_OUT_FORWARD:
            KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
            break;
        case TAB_OUT_BACK:
            KeyboardFocusManager.getCurrentKeyboardFocusManager().focusPreviousComponent();
            break;
        case EDIT_PLUGIN:
            int[] rows = table.getSelectedRows();
            Object[] state = new Object[rows.length];
            for (int i = 0; i < rows.length; i++) {
                state[i] = pluginModel.getValueAt(rows[i], 0);
            }
            for (int i = 0; i < rows.length; i++) {
                pluginModel.setValueAt(state[i].equals(Boolean.FALSE), rows[i], 0);
            }
            break;
        case CLOSE_PLUGIN_MANAGER:
            window.ok();
            break;
        default:
            throw new InternalError();
    }
}