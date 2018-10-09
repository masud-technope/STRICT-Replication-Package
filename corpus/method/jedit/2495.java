//}}}
//}}}
//{{{ Line offset methods
//{{{ getLength() method
/**
	 * @return the number of characters in the buffer. This method is thread-safe.
	 */
public int getLength() {
    // no need to lock since this just returns a value and that's it
    return contentMgr.getLength();
}