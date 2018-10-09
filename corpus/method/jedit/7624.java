public CharSequence subSequence(int start, int end) {
    int baseLength = base.length();
    return new ReverseCharSequence(base.subSequence(baseLength - end, baseLength - start));
}