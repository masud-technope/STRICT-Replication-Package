//}}}
//{{{ init() method
/**
	 * Keeps track of mode initialization, to avoid overwriting
	 * custom mode properties in the user's settings.
	 */
@Override
public void init() {
    initialized = true;
    super.init();
}