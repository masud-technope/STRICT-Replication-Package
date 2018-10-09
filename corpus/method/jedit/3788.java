private boolean isFloat(String string) {
    if (string == null || string.isEmpty()) {
        return false;
    }
    try {
        if (".".equals(string)) {
            return true;
        }
        if (!positiveOnly && "-".equals(string)) {
            return true;
        }
        Float.parseFloat(string);
        return true;
    } catch (Exception e) {
        return false;
    }
}