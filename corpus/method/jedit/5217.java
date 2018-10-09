/**
	 * Creates a new registers changed message.
	 * @param source The message source
	 */
public  RegisterChanged(EBComponent source, char name) {
    super(source);
    registerName = name;
}