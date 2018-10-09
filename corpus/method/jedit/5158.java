public synchronized boolean isElectricKey(char ch) {
    if (electricKeys == null) {
        String[] props = { "indentOpenBrackets", "indentCloseBrackets", "electricKeys" };
        StringBuilder buf = new StringBuilder();
        for (String prop1 : props) {
            String prop = (String) getProperty(prop1);
            if (prop != null)
                buf.append(prop);
        }
        electricKeys = buf.toString();
    }
    return (electricKeys.indexOf(ch) >= 0);
}