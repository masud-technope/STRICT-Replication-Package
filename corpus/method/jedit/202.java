// New in JarBundler 2.2.0; Tobias Bley ---------------------------------
private void writeJVMArchs(List jvmArchs, Node appendTo) {
    writeKey("JVMArchs", appendTo);
    writeArray(jvmArchs, appendTo);
}