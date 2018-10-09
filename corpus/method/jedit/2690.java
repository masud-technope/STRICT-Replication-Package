//}}}
//{{{ getReplaceFromRemoveInsert() method
// a Replace Edit is a Remove Edit and then an Insert Edit
private Replace getReplaceFromRemoveInsert(Edit lastElement, Edit newElement) {
    if (lastElement instanceof Remove && newElement instanceof Insert) {
        // it's the identity is significant.
        if (lastElement == undoClearDirty || newElement == undoClearDirty)
            return null;
        /* newElement is guaranteed to be an Compound-Insert Edit, redoClearDirty will be an Normal-Insert, Normal-Remove,
			 * Compound-Remove-Insert-Edit or Compound-Replace-Edit (all possible edit operations)
			 * redoClearDirty cannot become equal to newElement because:
			 * - redoClearDirty will be set after the file has been saved and the first new change is made, which
			 *   could be an Normal-Insert, Normal-Remove, Compound-Replace-Edit, Compound-Remove-Insert-Edit,
			 *   or null, if this is the first change in the file at all.
			 *   For Compound-Edit case it will be the last element of the Compound edit.
			 * - As the first Remove&Insert sequence of a Compound-Edit is never compacted by above if statement,
			 *   redoClearDirty can never be any of the following Remove&Insert elements, as the user as no option to save the
			 *   file after the first Remove&Insert sequence, because the GUI is blocked by the search&replace all operation.
			 */
        assert newElement != redoClearDirty;
        assert lastElement != redoClearDirty;
        Remove rem = (Remove) lastElement;
        Insert ins = (Insert) newElement;
        if (rem.offset == ins.offset) {
            return new Replace(rem.offset, rem.str, ins.str);
        }
    }
    return null;
}