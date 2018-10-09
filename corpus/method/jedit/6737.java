//}}}
//{{{ transactionComplete() method
public void transactionComplete(JEditBuffer buffer) {
    if (!buffer.getBooleanProperty("elasticTabstops")) {
        return;
    }
    if ((buffer.getBooleanProperty("elasticTabstops")) && ((!handledInsertion) || (!handledDeletion))) {
        //if we reach here use brute force as a last resolve
        fullyUpdateColumnBlocks(buffer);
    }
}