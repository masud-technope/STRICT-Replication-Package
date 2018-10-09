@Override
public void keyPressed(KeyEvent evt) {
    if (evt.isConsumed())
        return;
    Component comp = getFocusOwner();
    if (evt.getKeyCode() == KeyEvent.VK_ENTER && enterEnabled) {
        while (comp != null) {
            if (comp instanceof JComboBox) {
                JComboBox<?> combo = (JComboBox<?>) comp;
                if (combo.isEditable()) {
                    Object selected = combo.getEditor().getItem();
                    if (selected != null)
                        combo.setSelectedItem(selected);
                }
                if (combo.isPopupVisible()) {
                    evt.consume();
                    combo.setPopupVisible(false);
                }
                return;
            }
            // TODO: add other classes that need custom key handling here.
            comp = comp.getParent();
        }
        evt.consume();
        ok();
    } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE || isCloseBufferShortcut(evt)) {
        evt.consume();
        if (comp instanceof JComboBox) {
            JComboBox<?> combo = (JComboBox<?>) comp;
            if (combo.isPopupVisible())
                combo.setPopupVisible(false);
            else
                cancel();
        } else
            cancel();
    }
}