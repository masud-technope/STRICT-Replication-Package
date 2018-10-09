public boolean equals(Object compareObj) {
    if (!(compareObj instanceof HyperSearchFileNode))
        return false;
    HyperSearchFileNode otherResult = (HyperSearchFileNode) compareObj;
    return path.equals(MiscUtilities.resolveSymlinks(otherResult.path));
}