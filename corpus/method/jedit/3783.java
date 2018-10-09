private boolean isInteger(String string) {
    if (string == null || string.isEmpty()) {
        return false;
    }
    try {
        if (!positiveOnly && "-".equals(string)) {
            return true;
        }
        Integer.parseInt(string);
        return true;
    } catch (Exception e) {
        return false;
    }
}