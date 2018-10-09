public String getElementAt(int index) {
    MirrorList.Mirror mirror = mirrors.get(index);
    if (mirror.id.equals(MirrorList.Mirror.NONE))
        return jEdit.getProperty("options.plugin-manager.none");
    else
        return mirror.continent + ": " + mirror.description + " (" + mirror.location + ')';
}