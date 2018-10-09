@Override
// for the cast
@SuppressWarnings({ "unchecked" })
protected Transferable createTransferable(JComponent c) {
    sourceList = (JList<E>) c;
    indices = sourceList.getSelectedIndices();
    return new MyTransferable<E>(sourceList.getSelectedValuesList());
}