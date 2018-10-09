//}}}
//{{{ pathEquals() method
/**
	 * @param path A canonical path
	 */
boolean pathEquals(String path) {
    return path.equals(MiscUtilities.resolveSymlinks(this.path));
}