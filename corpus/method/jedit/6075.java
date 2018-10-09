@Override
public void setTransferable(Transferable transferable) {
    clipboard.setContents(transferable, null);
}