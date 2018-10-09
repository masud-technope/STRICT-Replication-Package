private String showEvalString(String s) {
    s = s.replace('\n', ' ');
    s = s.replace('\r', ' ');
    if (s.length() > 80)
        s = s.substring(0, 80) + " . . . ";
    return s;
}