@Override
public long getLength() {
    fetchAttrs();
    return super.getLength();
}