/*
	public void setNameCompletionIncludeUnqNames( boolean b ) {
		if ( nameCompletionIncludesUnqNames != b ) {
			nameCompletionIncludesUnqNames = b;
			nameSpaceChanged();
		}
	}
*/
// Begin Static stuff
static String[] traverseDirForClasses(File dir) throws IOException {
    List list = traverseDirForClassesAux(dir, dir);
    return (String[]) list.toArray(new String[0]);
}