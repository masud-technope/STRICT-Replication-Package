//}}}
//{{{ getDepends() method
private String getDepends(Entry entry) {
    StringBuilder builder = new StringBuilder();
    Set<String> dependencies = entry.getDependencies();
    if (dependencies != null && !dependencies.isEmpty()) {
        builder.append("<br><br><b>").append(jEdit.getProperty("install-plugins.info.depends", "Depends on")).append("</b>:");
        List<String> depends = new ArrayList<String>(dependencies);
        Collections.sort(depends);
        int i = 0;
        for (String dep : depends) {
            if (i > 0)
                builder.append(',');
            builder.append(' ').append(dep);
            ++i;
        }
    }
    return builder.toString();
}