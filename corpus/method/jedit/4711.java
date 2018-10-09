//}}}
//{{{ fetchAttrs() method
/**
	 * Fetch some attributes of the file.
	 * Some attributes are not fetched during
	 * file initialization because it takes time.
	 * They are fetched here.
	 * VFS implementation should overwrite this
	 */
protected void fetchAttrs() {
    fetchedAttrs = true;
}