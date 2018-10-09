/**
	 * Determine if an archive record indicate End of Archive. End of
	 * archive is indicated by a record that consists entirely of null bytes.
	 *
	 * @param record The record data to check.
	 */
public boolean isEOFRecord(byte[] record) {
    for (int i = 0, sz = this.getRecordSize(); i < sz; ++i) if (record[i] != 0)
        return false;
    return true;
}