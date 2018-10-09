public void copy(InputStream in, String outfile, Progress progress) throws IOException {
    File outFile = new File(outfile);
    OperatingSystem.getOperatingSystem().mkdirs(outFile.getParent());
    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile));
    int count;
    for (; ; ) {
        count = in.read(buf, 0, Math.min(in.available(), buf.length));
        if (count == -1 || count == 0)
            break;
        out.write(buf, 0, count);
        if (progress != null)
            progress.advance(count);
    }
    //in.close();
    out.close();
}