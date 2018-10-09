//}}}
void movePhysicalLine(int numLines) {
    if (numLines == 0)
        return;
    setPhysicalLine(getPhysicalLine() + numLines);
}