//}}}
//{{{ isLoaded() method
/**
	 * @return true if the buffer is loaded. This method is thread-safe.
	 */
public boolean isLoaded() {
    return !isLoading();
}