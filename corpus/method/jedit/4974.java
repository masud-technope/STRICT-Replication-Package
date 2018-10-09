//}}}
//{{{ loadIfNecessary() method
/**
	 * Loads the mode from disk if it hasn't been loaded already.
	 * @since jEdit 4.3pre10
	 */
@Override
public void loadIfNecessary() {
    if (marker == null) {
        jEdit.loadMode(this);
        if (marker == null)
            Log.log(Log.ERROR, this, "Mode not correctly loaded, token marker is still null");
    }
}