//}}}
//{{{ prev() method
int prev(int line) {
    int index = search(line);
    /* before first visible line */
    if (index == -1)
        return -1;
    else /* in collapsed range */
    if (index % 2 == 1) {
        /* end of prev expanded range */
        return fvm[index] - 1;
    } else /* first in expanded range */
    if (line == fvm[index]) {
        /* equal to first visible line */
        if (index == 0)
            return -1;
        else
            return fvm[index - 1] - 1;
    } else
        return line - 1;
}