@Override
public String getTwoStageSaveName(String path) {
    File parent = new File(getParentOfPath(path));
    return (parent.canWrite() || OperatingSystem.isWindows()) ? super.getTwoStageSaveName(path) : null;
}