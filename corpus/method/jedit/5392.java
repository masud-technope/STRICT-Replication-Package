//}}}
//{{{ getMinLineNumberDigits() method
public static int getMinLineNumberDigits() {
    int n = jEdit.getIntegerProperty("view.gutter.minDigitCount", 2);
    if (n < 0)
        n = 2;
    return n;
}