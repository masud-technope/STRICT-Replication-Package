//}}}
//{{{ getCode() method
@Override
public String getCode() {
    return "new DirectoryListSet(\"" + StandardUtilities.charsToEscapes(directory) + "\",\"" + StandardUtilities.charsToEscapes(glob) + "\"," + recurse + ')';
}