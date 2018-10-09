//{{{ contentRemoved() method
void contentRemoved(int offset, int length) {
    if (offset > this.offset)
        throw new ArrayIndexOutOfBoundsException();
    if (this.offset <= offset + length)
        this.offset = offset;
    else
        this.offset -= length;
    checkInvariants();
//}}}
}