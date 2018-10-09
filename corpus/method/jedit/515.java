/**
	 * Set this entry's modification time.
	 *
	 * @param time This entry's new modification time.
	 */
public void setModTime(Date time) {
    this.header.modTime = time.getTime() / 1000;
}