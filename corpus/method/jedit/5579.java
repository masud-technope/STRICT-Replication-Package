//}}}
//{{{ getPluginDepends() method
private static PluginDepends[] getPluginDepends(String classname) throws IllegalArgumentException {
    List<PluginDepends> ret = new ArrayList<PluginDepends>();
    int i = 0;
    String dep;
    while ((dep = jEdit.getProperty("plugin." + classname + ".depend." + i++)) != null) {
        boolean optional;
        if (dep.startsWith("optional ")) {
            optional = true;
            dep = dep.substring("optional ".length());
        } else {
            optional = false;
        }
        int index = dep.indexOf(' ');
        if (index == -1)
            throw new IllegalArgumentException("wrong dependency");
        String what = dep.substring(0, index);
        String arg = dep.substring(index + 1);
        PluginDepends depends = new PluginDepends();
        depends.what = what;
        depends.arg = arg;
        depends.optional = optional;
        depends.dep = dep;
        if ("plugin".equals(what))
            depends.name = arg.indexOf(' ') > 0 ? arg.substring(0, arg.indexOf(' ')) : arg;
        ret.add(depends);
    }
    return ret.toArray(new PluginDepends[ret.size()]);
}