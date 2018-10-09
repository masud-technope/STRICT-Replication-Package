// }}}
//{{{ invoke() method
/**
	 * Invokes the action. This is an implementation of the Command pattern,
	 * and concrete actions should override this.
	 *
	 * @param arg the argument
	 */
public abstract void invoke(E arg);