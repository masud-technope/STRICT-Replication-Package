@Override
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source instanceof JRadioButton) {
        combo.setEnabled(action.isSelected());
        list.setEnabled(action.isSelected());
    }
    if (source == ok)
        ok();
    else if (source == cancel)
        cancel();
    else if (source == combo)
        updateList();
}