public  LoadPerspectiveAction(String layoutName) {
    super(LOAD_PREFIX + layoutName, new String[] { layoutName });
    jEdit.setTemporaryProperty(LOAD_PREFIX + layoutName + ".label", LOAD_PREFIX + layoutName);
}