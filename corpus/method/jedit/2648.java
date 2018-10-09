//{{{ checkInvariants() method
private void checkInvariants() {
    if (offset < 0 || offset > buffer.getLength())
        throw new ArrayIndexOutOfBoundsException();
//}}}
}