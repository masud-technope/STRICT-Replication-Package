//{{{ AbbrevsModel constructor
 AbbrevsModel(Map<String, String> abbrevHash) {
    abbrevs = new Vector<Abbrev>();
    if (abbrevHash != null) {
        Set<Map.Entry<String, String>> entrySet = abbrevHash.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            abbrevs.add(new Abbrev(entry.getKey(), entry.getValue()));
        }
        sort(0);
    }
//}}}
}