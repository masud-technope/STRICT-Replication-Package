//}}}
//{{{ _getFiles() method
@Override
protected String[] _getFiles(Component comp) {
    Buffer[] buffers = view.getBuffers();
    List<String> returnValue = new ArrayList<String>(buffers.length);
    Pattern filter;
    try {
        filter = Pattern.compile(StandardUtilities.globToRE(glob), Pattern.CASE_INSENSITIVE);
    } catch (Exception e) {
        Log.log(Log.ERROR, this, "Error compiling Glob Pattern: " + glob, e);
        return null;
    }
    for (Buffer buffer : buffers) {
        if (filter.matcher(buffer.getName()).matches())
            returnValue.add(buffer.getPath());
    }
    return returnValue.toArray(new String[returnValue.size()]);
}