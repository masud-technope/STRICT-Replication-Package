//}}}
//{{{ dispose() method
private void dispose() {
    buffer.removeBufferListener(bufferHandler);
    buffer.removeBufferListener(elasticTabStopListener);
}