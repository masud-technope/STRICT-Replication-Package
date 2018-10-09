void install(Roster roster, String installDirectory, boolean downloadSource, boolean asDependency) {
    String installed = getInstalledPath();
    Branch branch = getCompatibleBranch();
    if (branch.obsolete) {
        if (installed != null)
            roster.addRemove(installed);
        return;
    }
    if (installedVersion != null && installedPath != null && !loaded && asDependency) {
        roster.addLoad(installedPath);
        return;
    }
    if (installed != null) {
        installDirectory = MiscUtilities.getParentOfPath(installed);
    }
    roster.addInstall(installed, downloadSource ? branch.downloadSource : branch.download, installDirectory, downloadSource ? branch.downloadSourceSize : branch.downloadSize);
}