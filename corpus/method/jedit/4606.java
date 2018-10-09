@Override
public boolean isWriteable() {
    fetchAttrs();
    return super.isWriteable();
}