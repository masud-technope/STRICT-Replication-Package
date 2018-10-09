/**
		Reflect Manager Set Accessible.
		Convenience method to invoke the reflect manager.
		@throws Unavailable    // weirdness with mode file, leave in the tab preceding this comment
	*/
public static boolean RMSetAccessible(Object obj) throws Unavailable {
    return getReflectManager().setAccessible(obj);
}