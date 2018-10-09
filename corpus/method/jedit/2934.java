//}}}
//{{{ addToBus() method
/**
	 * Adds a component to the bus. Methods annotated with the
	 * {@link EBHandler} annotation found in the component will
	 * be used as EditBus message handlers if a message of a
	 * matching type is sent on the bus.<p>
	 *
	 * If the component implements {@link EBComponent}, then the
	 * {@link EBComponent#handleMessage(EBMessage)} method will be
	 * called for every message sent on the bus.
	 *
	 * @param comp The component to add
	 *
	 * @since jEdit 4.3pre19
	 */
public static void addToBus(Object comp) {
    components.addComponent(comp);
}