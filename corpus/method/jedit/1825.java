public  ParseException(String message) {
    // null node, null callstack, ParseException knows where the error is.
    super(message, null, null);
    // End BeanShell Modification - super constructor args
    specialConstructor = false;
}