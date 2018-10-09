void satisfy(Roster roster, String installDirectory, boolean downloadSource) {
    if (what.equals("plugin")) {
        String installedVersion = plugin.getInstalledVersion();
        for (int i = 0; i < plugin.branches.size(); i++) {
            Branch branch = plugin.branches.get(i);
            if ((installedVersion == null || StandardUtilities.compareStrings(installedVersion, branch.version, false) < 0) && (from == null || StandardUtilities.compareStrings(branch.version, from, false) >= 0) && (to == null || StandardUtilities.compareStrings(branch.version, to, false) <= 0)) {
                plugin.install(roster, installDirectory, downloadSource, false);
                return;
            }
        }
    }
}