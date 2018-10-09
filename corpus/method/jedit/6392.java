// Only used by SettingsXML#opneSaver().
 Saver() throws IOException {
    this(new File(file.getParentFile(), "#" + file.getName() + "#save#"));
}