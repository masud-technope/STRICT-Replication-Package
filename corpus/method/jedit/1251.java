public byte[] getCode(String className) {
    return readBytesFromFile(getDir(), className);
}