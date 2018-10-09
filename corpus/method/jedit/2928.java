//}}}
//{{{ invoke() method
/**
	 * Invokes the action. This is an implementation of the Command pattern,
	 * and concrete actions should override this.
	 * 
	 * @param view The view
	 * @since jEdit 2.7pre2
	 * abstract since jEdit 4.3pre7
	 */
public abstract void invoke(View view);