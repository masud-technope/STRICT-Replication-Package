/**
	 * Creates a new properties changing message.
	 * @param source 	The message source
	 * @param state		An enum describing what is happening.
	 */
public  PropertiesChanging(EBComponent source, State state) {
    super(source);
    assert (state != null) : "state shouldn't be null";
    this.state = state;
}