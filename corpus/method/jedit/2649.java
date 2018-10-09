//{{{ unref() method
void unref() {
    if (--ref == 0)
        positions.remove(this);
//}}}
}