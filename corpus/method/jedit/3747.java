@Override
public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src == tail) {
        tailIsOn = !tailIsOn;
        jEdit.setBooleanProperty("log-viewer.tail", tailIsOn);
        if (tailIsOn) {
            scrollToTail();
        }
    } else if (src == copy) {
        StringBuilder buf = new StringBuilder();
        // TODO: list.getSelectedValues is deprecated. Need to finish the
        // conversion to generics for this class at some point.
        Object[] selected = list.getSelectedValues();
        if (selected != null && selected.length != 0) {
            for (Object sel : selected) {
                buf.append(sel);
                buf.append('\n');
            }
        } else {
            ListModel model = list.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                buf.append(model.getElementAt(i));
                buf.append('\n');
            }
        }
        Registers.setRegister('$', buf.toString());
    }
}