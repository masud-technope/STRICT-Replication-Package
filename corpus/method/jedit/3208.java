//}}}
//{{{ isPrefixActive() method
/**
	 * Returns if a prefix key has been pressed.
	 */
@Override
public boolean isPrefixActive() {
    return bindings != currentBindings || super.isPrefixActive();
}