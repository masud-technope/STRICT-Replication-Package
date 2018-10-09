//}}}
//{{{ getPath() method
/**
	  * @param shortVersion if true, replaces home path with ~/ on unix
	  * @return the path
	  */
public String getPath(Boolean shortVersion) {
    return shortVersion ? MiscUtilities.abbreviateView(path) : getPath();
}