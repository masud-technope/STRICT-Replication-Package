//}}}
//{{{ getSize() method
@Override
public int getSize() {
    if (wrap)
        return ring.length;
    else
        return count;
}