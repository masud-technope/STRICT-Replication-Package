//}}}
//{{{ startDocument() method
public void startDocument() {
    props = new Hashtable<String, String>();
    pushElement(null, null);
    reloadModes = new Vector<Mode>();
}