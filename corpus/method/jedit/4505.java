//}}}
//{{{ setBindings() method
/**
	 * Replace the set of key bindings.
	 * @since jEdit 4.3pre1
	 */
public void setBindings(Hashtable bindings) {
    this.bindings = this.currentBindings = bindings;
}