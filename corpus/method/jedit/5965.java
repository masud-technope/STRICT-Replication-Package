private String getMessage(String key) {
    String value = messageMap.get(key);
    return value == null ? key : value;
}