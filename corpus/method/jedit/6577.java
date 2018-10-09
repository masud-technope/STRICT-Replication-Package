//}}}
//{{{ endDocument() method
public void endDocument() {
    ParserRuleSet[] rulesets = marker.getRuleSets();
    for (int i = 0; i < rulesets.length; i++) {
        rulesets[i].resolveImports();
    }
    for (Mode mode : reloadModes) {
        mode.setTokenMarker(null);
        mode.loadIfNecessary();
    }
}