void setScrollLine(int scrollLine) {
    assert scrollLine >= 0;
    if (this.scrollLine != scrollLine) {
        setCallChanged(true);
        this.scrollLine = scrollLine;
    }
}