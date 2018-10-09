/**
		Re-throw the error, prepending the specified message.
	*/
public void reThrow(String msg) throws EvalError {
    prependMessage(msg);
    throw this;
}