/**
     * Close an entry. This method MUST be called for all file
     * entries that contain data. The reason is that we must
     * pad an entries data if it is of odd size.
     */
public void closeEntry() throws IOException {
    if (!inEntry) {
        throw new IOException("we are not in an entry currently");
    }
    if (this.currBytes < this.currSize) {
        throw new IOException("entry closed at '" + this.currBytes + "' before the '" + this.currSize + "' bytes specified in the header were written");
    }
    if (1 == (this.currSize & 1)) {
        this.out.write(ArConstants.PADDING, 0, 1);
    }
    inEntry = false;
}