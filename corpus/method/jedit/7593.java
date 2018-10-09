//}}}
//{{{ urgencyToString() method
private static String urgencyToString(int urgency) {
    switch(urgency) {
        case DEBUG:
            return "debug";
        case MESSAGE:
            return "message";
        case NOTICE:
            return "notice";
        case WARNING:
            return "warning";
        case ERROR:
            return "error";
    }
    throw new IllegalArgumentException("Invalid urgency: " + urgency);
}