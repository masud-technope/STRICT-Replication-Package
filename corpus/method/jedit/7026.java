//{{{ actionPerformed() method
@Override
public void actionPerformed(ActionEvent evt) {
    if (focusedComponent != null && focusedComponent.hasFocus())
        focusedComponent.blinkCaret();
//}}}
}