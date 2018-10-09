/**
     * Get this entry's modification time.
     *
     * @return time This entry's new modification time.
     */
public Date getFileDate() {
    return new Date(this.fileDate * MILLIS_PER_SECOND);
}