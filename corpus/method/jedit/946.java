//{{{ doComplete() method
public String doComplete(String path, String complete, boolean dirsOnly) {
    Log.log(Log.DEBUG, VFSFileNameField.class, "doComplete(" + path + "," + complete + "," + dirsOnly);
    for (; ; ) {
        if (complete.length() == 0)
            return path;
        int index = MiscUtilities.getFirstSeparatorIndex(complete);
        if (index == -1)
            return path;
        /* Until the very last path component, we only complete on
			directories */
        String newPath = VFSFile.findCompletion(path, complete.substring(0, index), browser, true);
        if (newPath == null)
            return null;
        path = newPath;
        complete = complete.substring(index + 1);
    }
}