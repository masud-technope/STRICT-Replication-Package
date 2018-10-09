// --------------------------------------------------------------------------
// Other public methods
// --------------------------------------------------------------------------
/**
   * Returns the bytecode of the class that was build with this class writer.
   *
   * @return the bytecode of the class that was build with this class writer.
   */
public byte[] toByteArray() {
    // computes the real size of the bytecode of this class
    int size = 24 + 2 * interfaceCount;
    if (fields != null) {
        size += fields.length;
    }
    int nbMethods = 0;
    CodeWriter cb = firstMethod;
    while (cb != null) {
        ++nbMethods;
        size += cb.getSize();
        cb = cb.next;
    }
    size += pool.length;
    int attributeCount = 0;
    if (sourceFile != null) {
        ++attributeCount;
        size += 8;
    }
    if ((access & Constants.ACC_DEPRECATED) != 0) {
        ++attributeCount;
        size += 6;
    }
    if (innerClasses != null) {
        ++attributeCount;
        size += 8 + innerClasses.length;
    }
    // allocates a byte vector of this size, in order to avoid unnecessary
    // arraycopy operations in the ByteVector.enlarge() method
    ByteVector out = new ByteVector(size);
    out.put4(0xCAFEBABE).put2(3).put2(45);
    out.put2(index).putByteArray(pool.data, 0, pool.length);
    out.put2(access).put2(name).put2(superName);
    out.put2(interfaceCount);
    for (int i = 0; i < interfaceCount; ++i) {
        out.put2(interfaces[i]);
    }
    out.put2(fieldCount);
    if (fields != null) {
        out.putByteArray(fields.data, 0, fields.length);
    }
    out.put2(nbMethods);
    cb = firstMethod;
    while (cb != null) {
        cb.put(out);
        cb = cb.next;
    }
    out.put2(attributeCount);
    if (sourceFile != null) {
        out.put2(newUTF8("SourceFile").index).put4(2).put2(sourceFile.index);
    }
    if ((access & Constants.ACC_DEPRECATED) != 0) {
        out.put2(newUTF8("Deprecated").index).put4(0);
    }
    if (innerClasses != null) {
        out.put2(newUTF8("InnerClasses").index);
        out.put4(innerClasses.length + 2).put2(innerClassesCount);
        out.putByteArray(innerClasses.data, 0, innerClasses.length);
    }
    return out.data;
}