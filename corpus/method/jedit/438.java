public String getInstallDirectory(String name, String version) {
    String programDir = System.getenv("ProgramFiles");
    // JRE 5. JRE 6 doesn't support Windows 98 and ME.
    if (programDir == null) {
        // This is a hint for what is needed here.
        programDir = "%ProgramFiles%";
    }
    return programDir + "\\" + name + " " + version;
}