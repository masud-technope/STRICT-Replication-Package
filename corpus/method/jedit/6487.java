//}}}
//{{{ addUserMode() method
/**
	 * Do not call this method. It is only public so that classes
	 * in the org.gjt.sp.jedit.syntax package can access it.
	 * @since jEdit 4.3pre10
	 * @see org.gjt.sp.jedit.jEdit#reloadModes reloadModes
	 * @param mode The edit mode
	 */
public void addUserMode(Mode mode, Path target) throws IOException {
    mode.setUserMode(true);
    String name = mode.getName();
    String modeFile = (String) mode.getProperty("file");
    String filenameGlob = (String) mode.getProperty("filenameGlob");
    String firstLineGlob = (String) mode.getProperty("firstlineGlob");
    // copy mode file to user mode directory
    Path source = FileSystems.getDefault().getPath(modeFile);
    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    // add entry to mode catalog, catalog is in the same directory as the mode file
    File catalogFile = new File(target.toFile().getParent(), "catalog");
    if (catalogFile.exists()) {
        try {
            // read in the catalog file
            BufferedReader br = new BufferedReader(new FileReader(catalogFile));
            String line = null;
            StringBuilder contents = new StringBuilder();
            while ((line = br.readLine()) != null) {
                contents.append(line).append('\n');
            }
            br.close();
            // remove any existing catalog entry for this mode
            Pattern p = Pattern.compile("(?m)(^\\s*[<]MODE.*?NAME=\"" + name + "\".*?[>])");
            Matcher m = p.matcher(contents);
            String newContents = m.replaceFirst("<!--$1-->");
            // insert the catalog entry for this mode
            p = Pattern.compile("(?m)(</MODES>)");
            m = p.matcher(contents);
            StringBuilder modeLine = new StringBuilder("\t<MODE NAME=\"");
            modeLine.append(name).append("\" FILE=\"").append(target.toFile().getName()).append("\"");
            modeLine.append(filenameGlob == null || filenameGlob.isEmpty() ? "" : " FILE_NAME_GLOB=\"" + filenameGlob + "\"");
            modeLine.append(firstLineGlob == null || firstLineGlob.isEmpty() ? "" : " FIRST_LINE_GLOB=\"" + firstLineGlob + "\"");
            modeLine.append("/>");
            newContents = m.replaceFirst(modeLine + "\n$1");
            // rewrite the catalog file
            BufferedWriter bw = new BufferedWriter(new FileWriter(catalogFile));
            bw.write(newContents, 0, newContents.length());
            bw.flush();
            bw.close();
        } catch (Exception // NOPMD
        e) {
        }
    }
    addMode(mode);
    loadMode(mode);
}