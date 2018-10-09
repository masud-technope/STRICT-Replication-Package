/**
	 * @param arg the arguments of the action
	 * @param newArgs new argument list
	 */
public final void invoke(E arg, Object[] newArgs) {
    args = newArgs;
    invoke(arg);
}