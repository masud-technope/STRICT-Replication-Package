public String detectEncoding(InputStream sample) throws IOException {
    byte[] mark = new byte[4];
    int count = sample.read(mark);
    byte low = (byte) (BOM16 & 0xff);
    byte high = (byte) ((BOM16 >> 8) & 0xff);
    if (count >= 4) {
        if (mark[0] == low && mark[1] == high && mark[2] == 0x00 && mark[3] == 0x00) {
            return "X-UTF-32LE-BOM";
        } else if (mark[0] == 0x00 && mark[1] == 0x00 && mark[2] == high && mark[3] == low) {
            return "X-UTF-32BE-BOM";
        }
    }
    if (count >= 2) {
        if (mark[0] == low && mark[1] == high) {
            return "x-UTF-16LE-BOM";
        } else if (mark[0] == high && mark[1] == low) {
            // works as "UTF-16BE with BOM".
            return "UTF-16";
        }
    }
    if (count >= UTF8BOM.length) {
        int i = 0;
        while (i < UTF8BOM.length) {
            if (mark[i] != UTF8BOM[i]) {
                break;
            }
            ++i;
        }
        if (i == UTF8BOM.length) {
            return "UTF-8Y";
        }
    }
    return null;
}