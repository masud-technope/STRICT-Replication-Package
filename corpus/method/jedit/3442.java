/** An entry with default urgency <code>Log.ERROR</code> */
public  ErrorEntry(String path, String messageProp, Object[] args) {
    this(path, messageProp, args, Log.ERROR);
}