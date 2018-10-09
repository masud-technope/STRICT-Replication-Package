/**
   * Visits a LOOKUPSWITCH instruction.
   *
   * @param dflt beginning of the default handler block.
   * @param keys the values of the keys.
   * @param labels beginnings of the handler blocks. <tt>labels[i]</tt> is the
   *      beginning of the handler block for the <tt>keys[i]</tt> key.
   */
void visitLookupSwitchInsn(Label dflt, int keys[], Label labels[]);