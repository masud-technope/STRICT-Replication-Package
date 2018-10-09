//{{{ RangeMap constructor
 RangeMap(RangeMap copy) {
    this.fvm = copy.fvm.clone();
    this.fvmcount = copy.fvmcount;
}