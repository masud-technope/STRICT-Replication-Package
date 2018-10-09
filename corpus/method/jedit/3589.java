/**
	 * Create and show a new modal dialog.
	 *
	 * @param  parent  center dialog on this component.
	 * @param  binding  the action/macro that should get a binding.
	 * @param  allBindings  all other key bindings.
	 * @param  debugBuffer  debug info will be dumped to this buffer
	 * (may be null)
	 * @since jEdit 4.1pre7
	 */
public  GrabKeyDialog(Dialog parent, KeyBinding binding, List<KeyBinding> allBindings, Buffer debugBuffer) {
    super(parent, jEdit.getProperty("grab-key.title"), true);
    init(binding, allBindings, debugBuffer);
}