//}}}
//{{{ updateMirrorLabel method
private void updateMirrorLabel() {
    String currentMirror = jEdit.getProperty("plugin-manager.mirror.id");
    String mirrorName;
    if (currentMirror.equals(MirrorList.Mirror.NONE)) {
        mirrorName = "Plugin Central default";
    } else {
        mirrorName = jEdit.getProperty("plugin-manager.mirror.name");
        if (mirrorName == null)
            mirrorName = currentMirror;
    }
    mirrorLabel.setText(jEdit.getProperty("options.plugin-manager.mirror") + ' ' + mirrorName);
}