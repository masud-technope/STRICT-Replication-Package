//}}}
//{{{ addRule() method
public void addRule(ParserRule r) {
    ruleCount++;
    Character[] keys;
    if (null == r.upHashChars) {
        keys = new Character[1];
        if ((null == r.upHashChar) || (0 >= r.upHashChar.length)) {
            keys[0] = null;
        } else {
            keys[0] = Character.valueOf(r.upHashChar[0]);
        }
    } else {
        keys = new Character[r.upHashChars.length];
        int i = 0;
        for (char upHashChar : r.upHashChars) {
            keys[i++] = upHashChar;
        }
    }
    for (Character key : keys) {
        List<ParserRule> rules = ruleMap.get(key);
        if (null == rules) {
            rules = new ArrayList<ParserRule>();
            ruleMap.put(key, rules);
        }
        rules.add(r);
    }
}