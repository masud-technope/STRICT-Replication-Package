@Override
public String getSymlinkPath() {
    fetchAttrs();
    return super.getSymlinkPath();
}