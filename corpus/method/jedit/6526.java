//}}}
//{{{ getRules() method
public List<ParserRule> getRules(Character key) {
    List<ParserRule> rulesForNull = ruleMap.get(null);
    boolean emptyForNull = rulesForNull == null || rulesForNull.isEmpty();
    Character upperKey = key == null ? null : Character.valueOf(Character.toUpperCase(key.charValue()));
    List<ParserRule> rulesForKey = upperKey == null ? null : ruleMap.get(upperKey);
    boolean emptyForKey = rulesForKey == null || rulesForKey.isEmpty();
    if (emptyForNull && emptyForKey) {
        return Collections.emptyList();
    } else if (emptyForKey) {
        return rulesForNull;
    } else if (emptyForNull) {
        return rulesForKey;
    } else {
        int size = rulesForNull.size() + rulesForKey.size();
        List<ParserRule> mixed = new ArrayList<ParserRule>(size);
        mixed.addAll(rulesForKey);
        mixed.addAll(rulesForNull);
        return mixed;
    }
}