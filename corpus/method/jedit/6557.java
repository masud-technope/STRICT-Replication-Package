//{{{ hashCode() method
public int hashCode() {
    int code = 0;
    code += (parent != null) ? parent.hashCode() : 0;
    code += (inRule != null) ? inRule.hashCode() : 0;
    code += (rules != null) ? rules.hashCode() : 0;
    code += (spanEndSubst != null) ? spanEndSubst.hashCode() : 0;
    code += (spanEndSubstRegex != null) ? spanEndSubstRegex.hashCode() : 0;
    return code;
//}}}
}