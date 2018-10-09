// --------------------------------------------------------------------------
// Utility methods: control flow analysis algorithm
// --------------------------------------------------------------------------
/**
   * Computes the size of the arguments and of the return value of a method.
   *
   * @param desc the descriptor of a method.
   * @return the size of the arguments of the method (plus one for the implicit
   *      this argument), argSize, and the size of its return value, retSize,
   *      packed into a single int i = <tt>(argSize << 2) | retSize</tt>
   *      (argSize is therefore equal to <tt>i >> 2</tt>, and retSize to
   *      <tt>i & 0x03</tt>).
   */
private static int getArgumentsAndReturnSizes(final String desc) {
    int n = 1;
    int c = 1;
    while (true) {
        char car = desc.charAt(c++);
        if (car == ')') {
            car = desc.charAt(c);
            return n << 2 | (car == 'V' ? 0 : (car == 'D' || car == 'J' ? 2 : 1));
        } else if (car == 'L') {
            while (desc.charAt(c++) != ';') {
            }
            n += 1;
        } else if (car == '[') {
            while ((car = desc.charAt(c)) == '[') {
                ++c;
            }
            if (car == 'D' || car == 'J') {
                n -= 1;
            }
        } else if (car == 'D' || car == 'J') {
            n += 2;
        } else {
            n += 1;
        }
    }
}