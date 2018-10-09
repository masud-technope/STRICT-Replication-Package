//{{{ ok() method
@Override
public void ok() {
    if (widgetRadio.isSelected()) {
        value = (String) widgetCombo.getSelectedItem();
    } else {
        value = labelField.getText().trim();
    }
    dispose();
//}}}
}