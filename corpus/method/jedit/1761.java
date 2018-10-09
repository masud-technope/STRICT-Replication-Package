/**
   * Computes the future value of a bytecode offset.
   * <p>
   * Note: it is possible to have several entries for the same instruction
   * in the <tt>indexes</tt> and <tt>sizes</tt>: two entries (index=a,size=b)
   * and (index=a,size=b') are equivalent to a single entry (index=a,size=b+b').
   *
   * @param indexes current positions of the instructions to be resized. Each
   *      instruction must be designated by the index of its <i>last</i> byte,
   *      plus one (or, in other words, by the index of the <i>first</i> byte of
   *      the <i>next</i> instruction).
   * @param sizes the number of bytes to be <i>added</i> to the above
   *      instructions. More precisely, for each i < <tt>len</tt>,
   *      <tt>sizes</tt>[i] bytes will be added at the end of the instruction
   *      designated by <tt>indexes</tt>[i] or, if <tt>sizes</tt>[i] is
   *      negative, the <i>last</i> |<tt>sizes[i]</tt>| bytes of the instruction
   *      will be removed (the instruction size <i>must not</i> become negative
   *      or null).
   * @param begin index of the first byte of the source instruction.
   * @param end index of the first byte of the target instruction.
   * @return the future value of the given bytecode offset.
   */
static int getNewOffset(final int[] indexes, final int[] sizes, final int begin, final int end) {
    int offset = end - begin;
    for (int i = 0; i < indexes.length; ++i) {
        if (begin < indexes[i] && indexes[i] <= end) {
            // forward jump
            offset += sizes[i];
        } else if (end < indexes[i] && indexes[i] <= begin) {
            // backward jump
            offset -= sizes[i];
        }
    }
    return offset;
}