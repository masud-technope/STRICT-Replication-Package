//{{{ CompressedReplace constructor
 CompressedReplace(Replace r1) {
    super(r1.offset, r1.strRemove, r1.strInsert);
    offsets = new IntegerArray(4);
    offsets.add(r1.offset);
//}}}
}