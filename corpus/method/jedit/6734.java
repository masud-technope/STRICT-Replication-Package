//}}}
//{{{ fullyUpdateColumnBlocks() method
private void fullyUpdateColumnBlocks(JEditBuffer buffer) {
    buffer.indentUsingElasticTabstops();
    handledInsertion = true;
    handledDeletion = true;
    buffer.getColumnBlock().setDirtyStatus(false);
    textArea.chunkCache.invalidateChunksFromPhys(0);
    textArea.invalidateLineRange(0, buffer.getLineCount() - 1);
//textArea.getPainter().repaint();
}