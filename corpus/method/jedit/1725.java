public void visitField(final int access, final String name, final String desc, final Object value) {
    ++fieldCount;
    if (fields == null) {
        fields = new ByteVector();
    }
    fields.put2(access).put2(newUTF8(name).index).put2(newUTF8(desc).index);
    int attributeCount = 0;
    if (value != null) {
        ++attributeCount;
    }
    if ((access & Constants.ACC_SYNTHETIC) != 0) {
        ++attributeCount;
    }
    if ((access & Constants.ACC_DEPRECATED) != 0) {
        ++attributeCount;
    }
    fields.put2(attributeCount);
    if (value != null) {
        fields.put2(newUTF8("ConstantValue").index);
        fields.put4(2).put2(newCst(value).index);
    }
    if ((access & Constants.ACC_SYNTHETIC) != 0) {
        fields.put2(newUTF8("Synthetic").index).put4(0);
    }
    if ((access & Constants.ACC_DEPRECATED) != 0) {
        fields.put2(newUTF8("Deprecated").index).put4(0);
    }
}