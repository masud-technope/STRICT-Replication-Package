//}}}
//{{{ contentRemoved() method
/**
	 * Called when text is removed from the buffer.
	 * @param buffer The buffer in question
	 * @param startLine The first line
	 * @param offset The start offset, from the beginning of the buffer
	 * @param numLines The number of lines removed
	 * @param length The number of characters removed
	 * @since jEdit 4.3pre3
	 */
public void contentRemoved(JEditBuffer buffer, int startLine, int offset, int numLines, int length) {
    if (!buffer.elasticTabstopsOn) {
        return;
    }
    boolean isASimpleChar = false;
    ColumnBlock rootBlock = buffer.getColumnBlock();
    if (rootBlock == null) {
        return;
    }
    if ((numLines == 0) & (length == 1)) {
        isASimpleChar = true;
    }
    if ((!isASimpleChar)) {
        //we need to remove column blocks
        //find the column block lying just below the first line deleted
        ColumnBlock firstBlockEffected = rootBlock.searchChildren(startLine);
        //info we need to determine inside this if block
        int startLineToBuild = -1;
        int endLineToBuild = -1;
        ColumnBlock firstBlockToBeUpdated = null;
        ColumnBlock firstBlockToBeRemoved = null;
        ColumnBlock lastBlockToBeRemoved = null;
        if (firstBlockEffected != null) {
            int indexFirstBlockEffected = rootBlock.getChildren().indexOf(firstBlockEffected);
            ColumnBlock blockAboveFirstEffected = null;
            boolean justBelowBlock = false;
            if (indexFirstBlockEffected > 0) {
                blockAboveFirstEffected = (ColumnBlock) rootBlock.getChildren().get(indexFirstBlockEffected - 1);
                if (blockAboveFirstEffected.endLine == startLine - 1) {
                    justBelowBlock = true;
                }
            }
            int posFirstLine = firstBlockEffected.isLineWithinThisBlock(startLine);
            boolean firstLineLiesInside = posFirstLine == 0;
            boolean firstLineLiesAbove = posFirstLine < 0;
            int posLastLine = firstBlockEffected.isLineWithinThisBlock(startLine + numLines);
            boolean lastLineLiesInside = posLastLine == 0;
            boolean lastLineLiesAbove = posLastLine < 0;
            boolean lastLineLiesBelow = posLastLine > 0;
            //deletion above block
            if (lastLineLiesAbove) {
                //if last line lies above this block cannot be connected to a block above in this deletion without touching the block above
                /*if(justBelowBlock&&startLine+numLines+1==firstBlockEffected.startLine)
					{
						startLineToBuild=blockAboveFirstEffected.startLine;
						endLineToBuild= firstBlockEffected.endLine;
						firstBlockToBeRemoved = blockAboveFirstEffected;
						lastBlockToBeRemoved = firstBlockEffected;
					}*/
                firstBlockToBeUpdated = firstBlockEffected;
                //else
                //{	
                firstBlockToBeRemoved = lastBlockToBeRemoved = null;
                startLineToBuild = endLineToBuild = -1;
            //}	
            } else //deletion inside block
            if ((firstLineLiesInside || firstLineLiesAbove) && lastLineLiesInside) {
                startLineToBuild = Math.min(firstBlockEffected.startLine, startLine);
                endLineToBuild = firstBlockEffected.endLine - numLines;
                //if(indexFirstBlockEffected<rootBlock.getChildren().size()-1)
                //{	
                //firstBlockToBeUpdated =(ColumnBlock)rootBlock.getChildren().get(indexFirstBlockEffected+1) ;
                //}	
                firstBlockToBeRemoved = lastBlockToBeRemoved = firstBlockEffected;
                if (justBelowBlock) {
                    startLineToBuild = blockAboveFirstEffected.startLine;
                    firstBlockToBeRemoved = blockAboveFirstEffected;
                }
            } else //deletion might cover other blocks as well
            if (((firstLineLiesInside) || (firstLineLiesAbove)) && lastLineLiesBelow) {
                startLineToBuild = Math.min(startLine, firstBlockEffected.startLine);
                firstBlockToBeRemoved = firstBlockEffected;
                ColumnBlock blockBelow = rootBlock.searchChildren(startLine + numLines);
                int indexLastBlock = rootBlock.getChildren().indexOf(blockBelow);
                if (blockBelow != null) {
                    //deletion partially overlaps this block
                    if (blockBelow.isLineWithinThisBlock(startLine + numLines) == 0) {
                        if (justBelowBlock) {
                            startLineToBuild = blockAboveFirstEffected.startLine;
                            firstBlockToBeRemoved = blockAboveFirstEffected;
                        }
                        lastBlockToBeRemoved = blockBelow;
                        endLineToBuild = blockBelow.endLine - numLines;
                    //if(indexLastBlock<rootBlock.getChildren().size()-1)
                    //{
                    //firstBlockToBeUpdated = (ColumnBlock)rootBlock.getChildren().get(indexLastBlock+1);
                    //}
                    } else //deletion lies above this block
                    {
                        //do not need to consider blockJustAbove here as we cannot connect two column blocks without 
                        //ending on one of the lines of either
                        //firstBlockToBeUpdated = blockBelow;
                        //if we have reached here there is surely a block above this one 
                        lastBlockToBeRemoved = (ColumnBlock) rootBlock.getChildren().get(indexLastBlock - 1);
                        //if the first Block is wholly covered then all column blocks are being deleted completely and there is nothing to build
                        endLineToBuild = firstLineLiesAbove ? -1 : startLine;
                        //consider the case where last line deleted is just above the column block block below
                        if ((blockBelow.startLine == startLine + numLines + 1) && (endLineToBuild != -1)) {
                            endLineToBuild = blockBelow.endLine - numLines;
                            lastBlockToBeRemoved = blockBelow;
                        }
                        if (endLineToBuild == -1) {
                            startLineToBuild = -1;
                        }
                    }
                } else //no block below last line
                {
                    lastBlockToBeRemoved = (ColumnBlock) rootBlock.getChildren().get(rootBlock.getChildren().size() - 1);
                    //firstBlockToBeUpdated = null;
                    if (firstLineLiesInside) {
                        endLineToBuild = startLine;
                    } else {
                        startLineToBuild = -1;
                        endLineToBuild = -1;
                    }
                }
            }
        } else //deletion lies below all column blocks
        {
            startLineToBuild = -1;
            endLineToBuild = -1;
            //firstBlockToBeUpdated = null;
            firstBlockToBeRemoved = null;
            lastBlockToBeRemoved = null;
        }
        //once we reach here we have three things to do
        //1)delete columnBlocks using firstBlockToBeDeleted and lastBlockToBeDeleted
        Vector<Node> blocksToBeRemoved = null;
        if (firstBlockToBeRemoved != null) {
            int startIndex = rootBlock.getChildren().indexOf(firstBlockToBeRemoved);
            blocksToBeRemoved = new Vector<Node>();
            if (lastBlockToBeRemoved == null) {
                throw new IllegalArgumentException("Deletion not handled properly");
            }
            int endIndex = rootBlock.getChildren().indexOf(lastBlockToBeRemoved);
            for (int i = startIndex; i <= endIndex; i++) {
                blocksToBeRemoved.add(rootBlock.getChildren().get(i));
            }
        }
        //2)update startLine/endLine in column blocks using firstBlockToBeUpdated
        if (numLines > 0) {
            rootBlock.endLine -= numLines;
            if ((lastBlockToBeRemoved != null) || (firstBlockToBeUpdated != null)) {
                int startIndex = -1;
                if (lastBlockToBeRemoved != null) {
                    startIndex = rootBlock.getChildren().indexOf(lastBlockToBeRemoved);
                    //start just after the last block to be removed
                    startIndex++;
                } else if (firstBlockToBeUpdated != null) {
                    startIndex = rootBlock.getChildren().indexOf(firstBlockToBeUpdated);
                }
                for (int i = startIndex; i < rootBlock.getChildren().size(); i++) {
                    ((ColumnBlock) rootBlock.getChildren().get(i)).updateLineNo(-1 * numLines);
                }
            }
        }
        //once we are done with (2) we can safely change rootBlock
        if (blocksToBeRemoved != null) {
            rootBlock.getChildren().removeAll(blocksToBeRemoved);
        }
        //3)rebuild column blocks using endLine and startLine
        if (startLineToBuild != -1 && endLineToBuild != -1) {
            buffer.updateColumnBlocks(startLineToBuild, endLineToBuild, 0, rootBlock);
            rootBlock.setDirtyStatus(false);
            textArea.chunkCache.invalidateChunksFromPhys(startLineToBuild);
            textArea.invalidateLineRange(startLineToBuild, endLineToBuild);
        }
        rootBlock.setDirtyStatus(false);
        handledDeletion = true;
    } else {
        int startingLine = -1;
        int endLine = -1;
        //a simple char has been entered 
        //if this lies inside a column block update the startIndex and endIndex of this blocks corresponding ColumnBlockLine
        //and all subsequent ColumnBlock Lines after this one
        //check whether columnBlockWidth is valid 
        ColumnBlock innerContainingBlock = rootBlock.getContainingBlock(startLine, offset);
        //do nothing if this char does not lie inside a column block
        if (innerContainingBlock != null) {
            if (!singleTabDeleted) {
                innerContainingBlock.updateColumnBlockLineOffset(startLine, -1 * length, false);
                startingLine = innerContainingBlock.startLine;
                endLine = innerContainingBlock.endLine;
                innerContainingBlock.setTabSizeDirtyStatus(true, false);
            } else {
                //no need to update line offset as ColumnBlock would be rebuilt
                ColumnBlock innerParent = (ColumnBlock) innerContainingBlock.getParent();
                startingLine = innerContainingBlock.startLine;
                endLine = innerContainingBlock.endLine;
                innerParent.getChildren().remove(innerContainingBlock);
                //startingLine =  innerParent.startLine;
                //endLine =  innerParent.endLine;
                //innerParent.getChildren().removeAllElements();
                buffer.updateColumnBlocks(startingLine, endLine, (int) innerParent.columnBlockWidth, innerParent);
            }
        } else {
            //this line must have been  retokenized and repainted by the BufferHandler so repaint it again here after column blocks dirty status is updated 
            startingLine = startLine;
            endLine = startLine;
        }
        handledDeletion = true;
        rootBlock.setDirtyStatus(false);
        if (startingLine != -1 && endLine != -1) {
            textArea.chunkCache.invalidateChunksFromPhys(startingLine);
            textArea.invalidateLineRange(startingLine, endLine);
        }
    }
}