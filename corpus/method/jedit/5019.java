//{{{ Handler constructor
protected  Handler(String name) {
    this.name = name;
    label = jEdit.getProperty("macro-handler." + name + ".label", name);
    try {
        filter = Pattern.compile(StandardUtilities.globToRE(jEdit.getProperty("macro-handler." + name + ".glob")));
    } catch (Exception e) {
        throw new InternalError("Missing or invalid glob for handler " + name);
    }
//}}}
}