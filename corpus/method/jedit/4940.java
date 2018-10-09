//}}}
//{{{ getAction() method
/**
	 * @return an action with the specified name.<p>
	 *
	 * <b>Deferred loading:</b> this will load the action set if necessary.
	 *
	 * @param name The action name
	 * @since jEdit 4.0pre1
	 */
@SuppressWarnings({ "unchecked" })
public E getAction(String name) {
    JEditAbstractEditAction obj = actions.get(name);
    if (obj == placeholder) {
        load();
        obj = actions.get(name);
        if (obj == placeholder) {
            Log.log(Log.WARNING, this, "Outdated cache");
            obj = null;
        }
    }
    return (E) obj;
}