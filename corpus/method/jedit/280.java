/**
     * Set this entry's modification time.
     *
     * @param time This entry's new modification time.
     */
public void setFileDate(Date time) {
    this.fileDate = time.getTime() / MILLIS_PER_SECOND;
}