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
            for (int row : rows) {
                Object st = pluginModel.getValueAt(row, 0);
                pluginModel.setValueAt(st.equals(Boolean.FALSE), row, 0);
            }
            break;
        case CLOSE_PLUGIN_MANAGER:
            window.ok();
            break;
        default:
            throw new InternalError();
    }
}