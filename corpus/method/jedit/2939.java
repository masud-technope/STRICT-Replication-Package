//}}}
//{{{ removeFromBus() method
/**
	 * Removes a component from the bus.
	 * @param comp The component to remove
	 * @since 4.3pre19
	 */
public static void removeFromBus(Object comp) {
    components.removeComponent(comp);
}