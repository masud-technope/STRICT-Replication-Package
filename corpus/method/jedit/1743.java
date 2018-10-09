/**
   * Visits a TABLESWITCH instruction.
   *
   * @param min the minimum key value.
   * @param max the maximum key value.
   * @param dflt beginning of the default handler block.
   * @param labels beginnings of the handler blocks. <tt>labels[i]</tt> is the
   *      beginning of the handler block for the <tt>min + i</tt> key.
   */
void visitTableSwitchInsn(int min, int max, Label dflt, Label labels[]);