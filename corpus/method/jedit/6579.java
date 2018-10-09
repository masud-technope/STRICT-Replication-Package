//{{{ XModeHandler constructor
public  XModeHandler(String modeName) {
    this.modeName = modeName;
    marker = new TokenMarker();
    marker.addRuleSet(new ParserRuleSet(modeName, "MAIN"));
    stateStack = new Stack<TagDecl>();
}