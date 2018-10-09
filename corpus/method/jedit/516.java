/**
	 * Set this entry's modification time. The parameter passed
	 * to this method is in "Java time".
	 *
	 * @param time This entry's new modification time.
	 */
public void setModTime(long time) {
    this.header.modTime = time / 1000;
}