/**
	 * Get the current record number, within the current block, zero based.
	 * Thus, current offset = (currentBlockNum * recsPerBlk) + currentRecNum.
	 *
	 * @return The current zero based record number.
	 */
public int getCurrentRecordNum() {
    return this.currRecIdx - 1;
}