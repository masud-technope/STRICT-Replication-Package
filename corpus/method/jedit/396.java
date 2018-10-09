public int getIntegerProperty(String name) {
    try {
        return Integer.parseInt(props.getProperty(name));
    } catch (Exception e) {
        return -1;
    }
}