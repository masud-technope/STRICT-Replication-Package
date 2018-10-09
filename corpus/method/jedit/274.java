/**
     * Construct an entry with only a name. This allows the programmer
     * to construct the entry's header "by hand". File is set to null.
     *
     * @param name the entry name
     */
public  ArEntry(String name) {
    this();
    if (name.endsWith("/")) {
        throw new IllegalArgumentException("ar archives can only contain files");
    }
    this.filename = new StringBuffer(name);
    this.mode = DEFAULT_FILE_MODE;
    this.userId = 0;
    this.groupId = 0;
    this.size = 0;
    this.fileDate = (new Date()).getTime() / MILLIS_PER_SECOND;
}