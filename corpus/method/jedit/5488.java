//{{{ actionPerformed() method
@Override
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == ok) {
        ok();
    } else if (source == cancel) {
        cancel();
    } else if (source == labelRadio) {
        labelField.setEnabled(true);
        widgetCombo.setEnabled(false);
        validate();
    } else if (source == widgetRadio) {
        labelField.setEnabled(false);
        widgetCombo.setEnabled(true);
        validate();
    }
//}}}
}