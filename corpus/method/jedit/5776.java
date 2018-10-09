boolean isSatisfied() {
    if (what.equals("plugin")) {
        for (int i = 0; i < plugin.branches.size(); i++) {
            String installedVersion = plugin.getInstalledVersion();
            if (installedVersion != null && (from == null || StandardUtilities.compareStrings(installedVersion, from, false) >= 0) && (to == null || StandardUtilities.compareStrings(installedVersion, to, false) <= 0)) {
                return true;
            }
        }
        return false;
    } else if (what.equals("jdk")) {
        String javaVersion = System.getProperty("java.version");
        // openjdk 9 returns just "9", not 1.X.X like previous versions
        javaVersion = javaVersion.length() >= 3 ? javaVersion.substring(0, 3) : javaVersion;
        if ((from == null || StandardUtilities.compareStrings(javaVersion, from, false) >= 0) && (to == null || StandardUtilities.compareStrings(javaVersion, to, false) <= 0))
            return true;
        else
            return false;
    } else if (what.equals("jedit")) {
        String build = jEdit.getBuild();
        if ((from == null || StandardUtilities.compareStrings(build, from, false) >= 0) && (to == null || StandardUtilities.compareStrings(build, to, false) <= 0))
            return true;
        else
            return false;
    } else {
        Log.log(Log.ERROR, this, "Invalid dependency: " + what);
        return false;
    }
}