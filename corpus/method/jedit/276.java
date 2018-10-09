/**
     * Construct an empty entry and prepares the header values.
     */
private  ArEntry() {
    this.magic = new StringBuffer(HEADERMAGIC);
    this.filename = new StringBuffer();
    this.userId = 0;
    this.groupId = 0;
    this.file = null;
}