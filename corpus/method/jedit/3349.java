public boolean saveLayout(String baseName, int viewIndex) {
    String lineSep = System.getProperty("line.separator");
    String filename = getLayoutFilename(baseName, viewIndex);
    BufferedWriter out = null;
    try {
        out = new BufferedWriter(new FileWriter(filename));
        out.write("<DOCKING LEFT=\"");
        out.write(left == null ? "" : left);
        out.write("\" TOP=\"");
        out.write(top == null ? "" : top);
        out.write("\" RIGHT=\"");
        out.write(right == null ? "" : right);
        out.write("\" BOTTOM=\"");
        out.write(bottom == null ? "" : bottom);
        out.write("\" LEFT_POS=\"");
        out.write(String.valueOf(leftPos));
        out.write("\" TOP_POS=\"");
        out.write(String.valueOf(topPos));
        out.write("\" RIGHT_POS=\"");
        out.write(String.valueOf(rightPos));
        out.write("\" BOTTOM_POS=\"");
        out.write(String.valueOf(bottomPos));
        out.write("\" />");
        out.write(lineSep);
    } catch (IOException e) {
        Log.log(Log.ERROR, this, e, e);
        return false;
    } finally {
        IOUtilities.closeQuietly((Closeable) out);
    }
    return true;
}