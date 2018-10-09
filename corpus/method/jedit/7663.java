public static String formatFileSize(long length) {
    if (length < 1024) {
        return length + " Bytes";
    } else if (length < 1024 << 10) {
        return KB_FORMAT.format((double) length / 1024);
    } else {
        return MB_FORMAT.format((double) length / 1024 / 1024);
    }
}