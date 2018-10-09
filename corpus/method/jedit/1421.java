/**
		Localize a path to the file name based on the bsh.cwd interpreter
		working directory.
	*/
public File pathToFile(String fileName) throws IOException {
    File file = new File(fileName);
    // if relative, fix up to bsh.cwd
    if (!file.isAbsolute()) {
        String cwd = (String) getu("bsh.cwd");
        file = new File(cwd + File.separator + fileName);
    }
    // No need for getAbsolutePath() here...
    return new File(file.getCanonicalPath());
}