//{{{ PosTopHalf constructor
 PosTopHalf(PosBottomHalf bh) {
    this.bh = bh;
    bh.ref();
//}}}
}