public void indentUsingElasticTabstops() {
    synchronized (columnBlockLock) {
        columnBlock = new ColumnBlock(this, 0, getLineCount() - 1);
        updateColumnBlocks(0, lineMgr.getLineCount() - 1, 0, columnBlock);
    }
}