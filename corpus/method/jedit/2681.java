//}}}
//{{{ getCompressedReplaceFromReplaceReplace() method
// a CompressedReplace Edit is one to many Replace Edit compressed via offsets
private CompressedReplace getCompressedReplaceFromReplaceReplace(Edit lastElement, Edit newElement) {
    if (newElement instanceof Replace) {
        CompressedReplace rep = null;
        // try to pack the next Replace into the CompressedReplace
        if (lastElement instanceof CompressedReplace) {
            rep = (CompressedReplace) lastElement;
            return rep.add((Replace) newElement);
        }
        // try to create a compressed Replace
        if (lastElement instanceof Replace) {
            rep = new CompressedReplace((Replace) lastElement);
            return rep.add((Replace) newElement);
        }
    }
    return null;
}