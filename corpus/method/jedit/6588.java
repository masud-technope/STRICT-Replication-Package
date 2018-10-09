//}}}
//{{{ getTokenMarker() method
/**
	 * Returns the token marker for the given mode.
	 * You must override this method so that the mode loader can resolve
	 * delegate targets.
	 * @param mode The mode name
	 * @since jEdit 4.2pre1
	 */
protected abstract TokenMarker getTokenMarker(String mode);