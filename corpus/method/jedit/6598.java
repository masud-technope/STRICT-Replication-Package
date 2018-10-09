void setPhysicalLine(int physicalLine) {
    assert physicalLine >= 0;
    if (this.physicalLine != physicalLine) {
        setCallChanged(true);
        this.physicalLine = physicalLine;
    }
}