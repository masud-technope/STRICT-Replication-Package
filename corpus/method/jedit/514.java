/**
	 * Set this entry's modification time.
	 *
	 * @param time This entry's new modification time.
	 */
public Date getModTime() {
    return new Date(this.header.modTime * 1000);
}