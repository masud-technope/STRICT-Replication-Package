//{{{ clone() method
@Override
public Object clone() {
    LineContext lc = new LineContext();
    lc.inRule = inRule;
    lc.rules = rules;
    lc.parent = (parent == null) ? null : (LineContext) parent.clone();
    lc.spanEndSubst = spanEndSubst;
    lc.spanEndSubstRegex = spanEndSubstRegex;
    lc.escapeRule = escapeRule;
    return lc;
//}}}
}