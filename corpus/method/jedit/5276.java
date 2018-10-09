//{{{ toHashtable() method
public Hashtable<String, String> toHashtable() {
    Hashtable<String, String> hash = new Hashtable<String, String>();
    for (Abbrev abbrev : abbrevs) {
        if (abbrev.abbrev.length() > 0 && abbrev.expand.length() > 0)
            hash.put(abbrev.abbrev, abbrev.expand);
    }
    return hash;
//}}}
}