//{{{ ParserRuleSet constructor
public  ParserRuleSet(String modeName, String setName) {
    this.modeName = modeName;
    this.setName = setName;
    ruleMap = new HashMap<Character, List<ParserRule>>();
    imports = new ArrayList<ParserRuleSet>();
}