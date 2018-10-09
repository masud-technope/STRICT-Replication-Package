//}}}
//{{{ addAction() method
/**
	 * Adds an action to the action set.
	 * It exists for binary compatibility issues
	 * @param action The action
	 * @since jEdit 4.0pre1
	 */
@Override
public // NOPMD
void addAction(// NOPMD
EditAction action) {
    super.addAction(action);
}