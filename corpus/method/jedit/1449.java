public void ReInit(java.io.InputStream dstream, int startline, int startcolumn, int buffersize) {
    ReInit(new java.io.InputStreamReader(dstream), startline, startcolumn, 4096);
}