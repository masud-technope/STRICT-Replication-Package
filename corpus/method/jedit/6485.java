//}}}
//{{{ removeMode() method
/**
	 * Will only remove user modes.
	 * @return true if the mode was removed, false otherwise.
	 */
public boolean removeMode(String name) throws IOException {
    Mode mode = modes.get(name);
    if (mode.isUserMode()) {
        // check that this mode is in the map
        Mode oldMode = modes.remove(name);
        if (oldMode == null)
            return false;
        // delete mode file from disk and remove the entry from the catalog file.
        // Actually, just rename the mode file by adding "_unused" to the end of the file name
        // and comment out the line in the catalog file. This way it is possible to undo
        // these changes manually without too much work.
        String modeFilename = (String) mode.getProperty("file");
        File modeFile = new File(modeFilename);
        if (modeFile.exists()) {
            Path path = FileSystems.getDefault().getPath(modeFilename);
            Files.move(path, path.resolveSibling(modeFilename + "_unused"), StandardCopyOption.REPLACE_EXISTING);
        }
        // The mode file may not be present and still referenced in the catalog, so carry on.
        // delete entry from mode catalog, catalog is in the same directory as the mode file
        File catalogFile = new File(modeFile.getParent(), "catalog");
        if (catalogFile.exists()) {
            StringBuilder contents = new StringBuilder();
            try {
                // read in the catalog file
                BufferedReader br = new BufferedReader(new FileReader(catalogFile));
                String line = null;
                while ((line = br.readLine()) != null) {
                    contents.append(line).append('\n');
                }
                br.close();
            } catch (IOException ioe) {
                modes.put(oldMode.getName(), oldMode);
                throw ioe;
            }
            if (contents.length() == 0) {
                // empty catalog file, how did that happen?
                modes.put(oldMode.getName(), oldMode);
                return false;
            }
            // remove the catalog entry for this mode
            Pattern p = Pattern.compile("(?m)(^\\s*[<]MODE.*?NAME=\"" + name + "\".*?[>])");
            Matcher m = p.matcher(contents);
            String newContents = m.replaceFirst("<!--$1-->");
            try {
                // rewrite the catalog file
                BufferedWriter bw = new BufferedWriter(new FileWriter(catalogFile));
                bw.write(newContents, 0, newContents.length());
                bw.flush();
                bw.close();
            } catch (IOException ioe) {
                modes.put(oldMode.getName(), oldMode);
                throw ioe;
            }
        }
    }
    return true;
}