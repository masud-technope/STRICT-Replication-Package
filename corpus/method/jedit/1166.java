/**
		If accessibility is enabled
		determine if the accessibility mechanism exists and if we have
		the optional bsh package to use it.
		Note that even if both are true it does not necessarily mean that we 
		have runtime permission to access the fields... Java security has
	 	a say in it.
		@see org.gjt.sp.jedit.bsh.ReflectManager
	*/
public static boolean haveAccessibility() {
    return accessibility;
}