public String[] getSavedLayouts() {
    String layoutDir = getLayoutDirectory();
    if (layoutDir == null)
        return null;
    File dir = new File(layoutDir);
    File[] files = dir.listFiles(new FilenameFilter() {

        public boolean accept(File dir, String name) {
            return name.endsWith(".xml");
        }
    });
    String[] layouts = new String[files.length];
    for (int i = 0; i < files.length; i++) layouts[i] = fileToLayout(files[i].getName());
    return layouts;
}