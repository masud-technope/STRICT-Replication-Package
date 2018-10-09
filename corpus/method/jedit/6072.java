@Override
public Transferable getTransferable() {
    return clipboard.getContents(this);
}