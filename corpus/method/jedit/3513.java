//}}}
//{{{ getSize() method
public int getSize() {
    if (filteredIndices == null)
        return delegated.getSize();
    return filteredIndices.size();
}