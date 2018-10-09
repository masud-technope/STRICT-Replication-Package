@Override
public long getModified() {
    fetchAttrs();
    return modified;
}