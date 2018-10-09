/**
	 * detects wether the installer is running from a path
	 * containing exclamation marks.
	 * This has been reported as a cause of failure on Linux and MS Windows :
	 * see bug #2065330 - Installer doesn't run on dir having ! as last char in name.
	 */
private static boolean isRunningFromExclam() {
    Class me = Install.class;
    ProtectionDomain domaine = me.getProtectionDomain();
    CodeSource source = domaine.getCodeSource();
    URL mySource = source.getLocation();
    // a problem occurs only when the ! is at the end of directory
    return mySource.toString().contains("!");
}