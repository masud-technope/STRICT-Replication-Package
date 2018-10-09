/**
		Set a java.lang.reflect Field, Method, Constructor, or Array of
		accessible objects to accessible mode.
		If the object is not an AccessibleObject then do nothing.
		@return true if the object was accessible or false if it was not.
	*/
// Arrays incomplete... need to use the array setter
public boolean setAccessible(Object obj) {
    if (obj instanceof AccessibleObject) {
        ((AccessibleObject) obj).setAccessible(true);
        return true;
    } else
        return false;
}