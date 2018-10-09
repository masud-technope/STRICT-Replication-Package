// }}}
// {{{ closeListener() method
/**
	 * The actionEvent "close-docking-area" by default only works on
	 * dockable windows that have no special keyboard handling.

	 * If you have dockable widgets with input widgets and/or other fancy
	 * keyboard handling, those components may not respond to close docking area.

	 * You can add key listeners to each keyboard-handling component
	 * in your dockable that usually has keyboard focus.
	 *
	 * This function creates and returns a key listener which does exactly that.
	 * It is also used by FloatingWindowContainer when creating new floating windows.
	 *
	 * @param dockableName the name of your dockable
	 * @return a KeyListener you can add to that plugin's component.
	 * @since jEdit 4.3pre6
	 *
	 */
public KeyListener closeListener(String dockableName) {
    return new KeyHandler(dockableName);
}