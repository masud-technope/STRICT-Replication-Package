//{{{ actionPerformed() method
@Override
public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == ok) {
        if (canClose())
            dispose();
    } else if (evt.getSource() == remove) {
        shortcut.setText(null);
        isOK = true;
        dispose();
    } else if (evt.getSource() == cancel)
        dispose();
    else if (evt.getSource() == clear) {
        shortcut.setText(null);
        if (debugBuffer == null)
            updateAssignedTo(null);
        shortcut.requestFocus();
    }
//}}}
}