public  JavaCharStream(java.io.InputStream dstream, int startline, int startcolumn, int buffersize) {
    this(new java.io.InputStreamReader(dstream), startline, startcolumn, 4096);
}