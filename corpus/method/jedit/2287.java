private static String accessorName(String getorset, String propName) {
    return getorset + String.valueOf(Character.toUpperCase(propName.charAt(0))) + propName.substring(1);
}