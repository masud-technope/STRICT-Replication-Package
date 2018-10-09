/**
   * Puts the bytecode of this method in the given byte vector.
   *
   * @param out the byte vector into which the bytecode of this method must be
   *      copied.
   */
final void put(final ByteVector out) {
    out.put2(access).put2(name.index).put2(desc.index);
    int attributeCount = 0;
    if (code.length > 0) {
        ++attributeCount;
    }
    if (exceptionCount > 0) {
        ++attributeCount;
    }
    if ((access & Constants.ACC_SYNTHETIC) != 0) {
        ++attributeCount;
    }
    if ((access & Constants.ACC_DEPRECATED) != 0) {
        ++attributeCount;
    }
    out.put2(attributeCount);
    if (code.length > 0) {
        int size = 12 + code.length + 8 * catchCount;
        if (localVar != null) {
            size += 8 + localVar.length;
        }
        if (lineNumber != null) {
            size += 8 + lineNumber.length;
        }
        out.put2(cw.newUTF8("Code").index).put4(size);
        out.put2(maxStack).put2(maxLocals);
        out.put4(code.length).putByteArray(code.data, 0, code.length);
        out.put2(catchCount);
        if (catchCount > 0) {
            out.putByteArray(catchTable.data, 0, catchTable.length);
        }
        attributeCount = 0;
        if (localVar != null) {
            ++attributeCount;
        }
        if (lineNumber != null) {
            ++attributeCount;
        }
        out.put2(attributeCount);
        if (localVar != null) {
            out.put2(cw.newUTF8("LocalVariableTable").index);
            out.put4(localVar.length + 2).put2(localVarCount);
            out.putByteArray(localVar.data, 0, localVar.length);
        }
        if (lineNumber != null) {
            out.put2(cw.newUTF8("LineNumberTable").index);
            out.put4(lineNumber.length + 2).put2(lineNumberCount);
            out.putByteArray(lineNumber.data, 0, lineNumber.length);
        }
    }
    if (exceptionCount > 0) {
        out.put2(cw.newUTF8("Exceptions").index).put4(2 * exceptionCount + 2);
        out.put2(exceptionCount);
        for (int i = 0; i < exceptionCount; ++i) {
            out.put2(exceptions[i]);
        }
    }
    if ((access & Constants.ACC_SYNTHETIC) != 0) {
        out.put2(cw.newUTF8("Synthetic").index).put4(0);
    }
    if ((access & Constants.ACC_DEPRECATED) != 0) {
        out.put2(cw.newUTF8("Deprecated").index).put4(0);
    }
}