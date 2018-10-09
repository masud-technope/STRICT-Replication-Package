//}}}
//{{{ expandAbbrev() method
private static Expansion expandAbbrev(String mode, String abbrev, int softTabSize, Vector<String> pp) {
    m_pp = pp;
    if (!loaded)
        load();
    // try mode-specific abbrevs first
    String expand = null;
    Hashtable<String, String> modeAbbrevs = modes.get(mode);
    if (modeAbbrevs != null)
        expand = modeAbbrevs.get(abbrev);
    if (expand == null)
        expand = globalAbbrevs.get(abbrev);
    if (expand == null)
        return null;
    else
        return new Expansion(expand, softTabSize, m_pp);
}