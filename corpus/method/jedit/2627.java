//}}}
//{{{ removeElement() method
@Override
public boolean removeElement(Object value) {
    for (int i = 0; i < getSize(); i++) {
        if (ring[i].equals(value)) {
            remove(i);
            return true;
        }
    }
    return false;
}