//}}}
/** @return an MD5 hash of the contents of the buffer */
private byte[] calculateHash() {
    final byte[] dummy = new byte[1];
    if (!jEdit.getBooleanProperty("useMD5forDirtyCalculation"))
        return dummy;
    return StandardUtilities.md5(getSegment(0, getLength()));
}