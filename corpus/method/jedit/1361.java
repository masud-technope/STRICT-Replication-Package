/**
		Prepend the message if it is non-null.
	*/
protected void prependMessage(String s) {
    if (s == null)
        return;
    if (message == null)
        message = s;
    else
        message = s + " : " + message;
}