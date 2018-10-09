// --------------------------------------------------------------------------
// Methods to compute offsets and to manage forward references
// --------------------------------------------------------------------------
/**
   * Puts a reference to this label in the bytecode of a method. If the position
   * of the label is known, the offset is computed and written directly.
   * Otherwise, a null offset is written and a new forward reference is declared
   * for this label.
   *
   * @param owner the code writer that calls this method.
   * @param out the bytecode of the method.
   * @param source the position of first byte of the bytecode instruction that
   *      contains this label.
   * @param wideOffset <tt>true</tt> if the reference must be stored in 4 bytes,
   *      or <tt>false</tt> if it must be stored with 2 bytes.
   * @throws IllegalArgumentException if this label has not been created by the
   *      given code writer.
   */
void put(final CodeWriter owner, final ByteVector out, final int source, final boolean wideOffset) {
    if (CodeWriter.CHECK) {
        if (this.owner == null) {
            this.owner = owner;
        } else if (this.owner != owner) {
            throw new IllegalArgumentException();
        }
    }
    if (resolved) {
        if (wideOffset) {
            out.put4(position - source);
        } else {
            out.put2(position - source);
        }
    } else {
        if (wideOffset) {
            addReference(-1 - source, out.length);
            out.put4(-1);
        } else {
            addReference(source, out.length);
            out.put2(-1);
        }
    }
}