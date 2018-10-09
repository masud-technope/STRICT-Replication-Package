//{{{ equals() method
@Override
public boolean equals(Object o) {
    if (!(o instanceof PosBottomHalf))
        return false;
    return ((PosBottomHalf) o).offset == offset;
//}}}
}