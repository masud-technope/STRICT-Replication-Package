@Override
public //{{{ addChild() method
void addChild(Node node) {
    // must add the children in sorted order
    ColumnBlock block = (ColumnBlock) node;
    ColumnBlock blockBelow = searchChildren(block.startLine);
    if (blockBelow != null) {
        if (blockBelow.isLineWithinThisBlock(block.endLine) >= 0) {
            throw new IllegalArgumentException("Overlapping column blocks: " + block + " \n&\n" + blockBelow);
        }
        int index = children.indexOf(blockBelow);
        children.add(index, node);
    } else {
        children.add(node);
    }
}