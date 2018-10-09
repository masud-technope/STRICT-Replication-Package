//}}}
//{{{ contentInserted() method
public void contentInserted(JEditBuffer buffer, int startLine, int offset, int numLines, int length) {
    if (!buffer.elasticTabstopsOn) {
        return;
    }
    String charDeleted;
    boolean isASimpleChar = false;
    boolean singleTabInserted = false;
    if ((numLines == 0) & (length == 1)) {
        isASimpleChar = true;
        charDeleted = buffer.getText(offset, length);
        if (charDeleted.equals("\t")) {
            singleTabInserted = true;
        }
    }
    ColumnBlock rootBlock = buffer.getColumnBlock();
    if (rootBlock == null) {
        return;
    }
    //System.out.println("BEFORE UPDATING COLUMN BLOCKS-----");
    //System.out.println(rootBlock);
    int indexofBlockAbove = -1;
    ColumnBlock block = rootBlock.searchChildren(startLine);
    ColumnBlock blockjustAbove = null;
    boolean liesWithinBlock = false;
    int startIndex = -1;
    if (block != null) {
        startIndex = rootBlock.getChildren().indexOf(block);
        indexofBlockAbove = startIndex - 1;
        if (block.isLineWithinThisBlock(startLine) == 0) {
            //if the line lies within this block we need to redraw it
            startIndex++;
            liesWithinBlock = true;
        }
    } else {
        startIndex = rootBlock.getChildren().size();
        indexofBlockAbove = startIndex - 1;
    }
    if (indexofBlockAbove >= 0 && ((ColumnBlock) (rootBlock.getChildren().get(indexofBlockAbove))).endLine + 1 == startLine) {
        blockjustAbove = (ColumnBlock) (rootBlock.getChildren().get(indexofBlockAbove));
    }
    if (numLines > 0) {
        rootBlock.endLine += numLines;
        for (int i = startIndex; i < rootBlock.getChildren().size(); i++) {
            ((ColumnBlock) (rootBlock.getChildren().get(i))).updateLineNo(numLines);
        }
    }
    int startingLine = -1;
    int endLine = -1;
    if (liesWithinBlock) {
        ColumnBlock innerContainingBlock = block.getContainingBlock(startLine, offset);
        if ((isASimpleChar) && !(innerContainingBlock == null && singleTabInserted)) {
            //do nothing if this char does not lie inside a column block
            if (innerContainingBlock != null) {
                if (!singleTabInserted) {
                    innerContainingBlock.updateColumnBlockLineOffset(startLine, length, false);
                    startingLine = innerContainingBlock.startLine;
                    innerContainingBlock.setTabSizeDirtyStatus(true, false);
                    endLine = innerContainingBlock.endLine;
                } else {
                    //no need to update line offset as ColumnBlock would be rebuilt
                    ColumnBlock innerParent = (ColumnBlock) innerContainingBlock.getParent();
                    //startingLine = innerContainingBlock.startLine;
                    //endLine = innerContainingBlock.endLine;
                    //innerParent.getChildren().remove(innerContainingBlock);
                    startingLine = innerParent.startLine;
                    endLine = innerParent.endLine;
                    innerParent.getChildren().removeAllElements();
                    buffer.updateColumnBlocks(startingLine, endLine, (int) innerParent.columnBlockWidth, innerParent);
                }
            } else /*else if(innerContainingBlock==null&&singleTabInserted)
				{
					//TODO handle this case when tab has been inserted in FRONT and not OUTSIDE of a column block
					//currently whole column block gets repainted in this case
				}*/
            {
                //this line must have been  retokenized and repainted by the BufferHandler so repaint it again here after column blocks dirty status is updated 
                startingLine = startLine;
                endLine = startLine;
            }
        }
        if ((!isASimpleChar) || (innerContainingBlock == null && singleTabInserted)) {
            startingLine = block.getStartLine();
            endLine = block.getEndLine() + numLines;
            rootBlock.getChildren().remove(block);
            buffer.updateColumnBlocks(startingLine, endLine, 0, rootBlock);
        }
    } else {
        Segment seg = new Segment();
        buffer.getText(offset, length, seg);
        if (buffer.getTabStopPosition(seg) >= 0) {
            if (blockjustAbove != null) {
                rootBlock.getChildren().remove(blockjustAbove);
                startingLine = blockjustAbove.startLine;
            } else {
                startingLine = startLine;
            }
            if ((block != null) && (block.startLine == startLine + numLines + 1)) {
                rootBlock.getChildren().remove(block);
                endLine = block.endLine;
            } else {
                endLine = startLine + numLines;
            }
            buffer.updateColumnBlocks(startingLine, endLine, 0, rootBlock);
        }
    }
    handledInsertion = true;
    rootBlock.setDirtyStatus(false);
    //System.out.println(rootBlock);
    if (startingLine != -1 && endLine != -1 && handledDeletion) {
        textArea.chunkCache.invalidateChunksFromPhys(startingLine);
        textArea.invalidateLineRange(startingLine, endLine);
    }
}