//{{{ add() method
CompressedReplace add(Replace rep) {
    if (this.strInsert.equals(rep.strInsert) && this.strRemove.equals(rep.strRemove)) {
        offsets.add(rep.offset);
        return this;
    }
    return null;
//}}}
}