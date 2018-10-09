/** @since 5.0pre1 */
public  ErrorEntry(String path, String messageProp, Object[] args, int urgency) {
    this.path = path;
    String message = jEdit.getProperty(messageProp, args);
    if (message == null)
        message = "Undefined property: " + messageProp;
    Log.log(urgency, this, path + ":");
    Log.log(urgency, this, message);
    Vector<String> tokenizedMessage = new Vector<String>();
    int lastIndex = -1;
    for (int i = 0; i < message.length(); i++) {
        if (message.charAt(i) == '\n') {
            tokenizedMessage.addElement(message.substring(lastIndex + 1, i));
            lastIndex = i;
        }
    }
    if (lastIndex != message.length()) {
        tokenizedMessage.addElement(message.substring(lastIndex + 1));
    }
    messages = new String[tokenizedMessage.size()];
    tokenizedMessage.copyInto(messages);
}