@Override
public boolean isReadable() {
    fetchAttrs();
    return super.isReadable();
}