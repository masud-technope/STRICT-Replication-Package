//}}}
//{{{ formatSize() method
private static String formatSize(int size) {
    NumberFormat df = NumberFormat.getInstance();
    df.setMaximumFractionDigits(1);
    df.setMinimumFractionDigits(0);
    String sizeText;
    if (size < 1048576)
        sizeText = (size >> 10) + "KB";
    else
        sizeText = df.format(size / 1048576.0d) + "MB";
    return sizeText;
}