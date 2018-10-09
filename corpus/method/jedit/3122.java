@Override
public Transferable createTransferable(JComponent c) {
    JList list = (JList) c;
    Buffer buffer = (Buffer) list.getSelectedValue();
    if (buffer == null) {
        return null;
    } else {
        return new BufferSwitcherTransferable(buffer, c);
    }
}