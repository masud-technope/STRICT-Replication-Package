//}}}
//{{{ countNewlines() method
private static int countNewlines(String s, int end) {
    int counter = 0;
    for (int i = 0; i < end; i++) {
        if (s.charAt(i) == '\n')
            counter++;
    }
    return counter;
}