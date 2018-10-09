//{{{ getElementAt() method
@Override
public String getElementAt(int index) {
    return ring[virtualToPhysicalIndex(index)];
}