public void perform(String installDir, Vector filesets) throws IOException {
    if (!enabled)
        return;
    mkdirs(directory);
    String name = installer.getProperty("app.name");
    // install man page
    String manpage = installer.getProperty("ostask.unix-man.manpage");
    InputStream in = getClass().getResourceAsStream("/" + manpage);
    installer.copy(in, new File(directory, manpage).getPath(), null);
}