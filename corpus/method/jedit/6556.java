//{{{ equals() method
public boolean equals(Object obj) {
    if (obj instanceof LineContext) {
        LineContext lc = (LineContext) obj;
        return lc.inRule == inRule && lc.rules == rules && Objects.equals(parent, lc.parent) && charArraysEqual(spanEndSubst, lc.spanEndSubst) && Objects.equals(spanEndSubstRegex, lc.spanEndSubstRegex);
    } else
        return false;
//}}}
}