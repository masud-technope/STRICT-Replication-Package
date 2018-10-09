@Override
public boolean accept(File pathname) {
    return pathname.isFile() && pathname.getName().endsWith("_keys.props");
}