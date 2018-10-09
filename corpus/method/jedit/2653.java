//{{{ compareTo() method
public int compareTo(PosBottomHalf posBottomHalf) {
    if (iteration)
        Log.log(Log.ERROR, this, "Consistency failure");
    return offset - posBottomHalf.offset;
//}}}
}