//}}}
//{{{ next() method
int next(int line) {
    int index = search(line);
    /* in collapsed range */
    if (index % 2 != 0) {
        /* beyond last visible line */
        if (fvmcount == index + 1)
            return -1;
        else
            return fvm[index + 1];
    } else /* last in expanded range */
    if (line == fvm[index + 1] - 1) {
        /* equal to last visible line */
        if (fvmcount == index + 2)
            return -1;
        else
            return fvm[index + 2];
    } else
        return line + 1;
}