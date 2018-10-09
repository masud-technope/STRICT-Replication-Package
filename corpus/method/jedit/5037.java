//}}}
//{{{ removePosition() method
void removePosition() {
    // forget the cached Position instance
    if (position != null) {
        pos = position.getOffset();
        position = null;
    }
}