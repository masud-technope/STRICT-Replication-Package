/**
     * Set this entry's modification time. The parameter passed
     * to this method is in "Java time".
     *
     * @param time This entry's new modification time.
     */
public void setFileDate(long time) {
    this.fileDate = time / MILLIS_PER_SECOND;
}