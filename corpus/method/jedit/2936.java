//}}}
//{{{ addToBus() method
/**
	 * Adds a component to the bus. It will receive all messages sent
	 * on the bus.
	 *
	 * @param comp The component to add
	 */
public static void addToBus(EBComponent comp) {
    addToBus((Object) comp);
}