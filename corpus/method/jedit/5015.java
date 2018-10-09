//{{{ accept() method
public boolean accept(String path) {
    return filter.matcher(MiscUtilities.getFileName(path)).matches();
//}}}
}