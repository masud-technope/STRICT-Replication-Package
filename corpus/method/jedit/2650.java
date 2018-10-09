//{{{ contentInserted() method
void contentInserted(int offset, int length) {
    if (offset > this.offset)
        throw new ArrayIndexOutOfBoundsException();
    this.offset += length;
    checkInvariants();
//}}}
}