/**
   * Adds a forward reference to this label. This method must be called only for
   * a true forward reference, i.e. only if this label is not resolved yet. For
   * backward references, the offset of the reference can be, and must be,
   * computed and stored directly.
   *
   * @param sourcePosition the position of the referencing instruction. This
   *      position will be used to compute the offset of this forward reference.
   * @param referencePosition the position where the offset for this forward
   *      reference must be stored.
   */
private void addReference(final int sourcePosition, final int referencePosition) {
    if (srcAndRefPositions == null) {
        srcAndRefPositions = new int[6];
    }
    if (referenceCount >= srcAndRefPositions.length) {
        int[] a = new int[srcAndRefPositions.length + 6];
        System.arraycopy(srcAndRefPositions, 0, a, 0, srcAndRefPositions.length);
        srcAndRefPositions = a;
    }
    srcAndRefPositions[referenceCount++] = sourcePosition;
    srcAndRefPositions[referenceCount++] = referencePosition;
}