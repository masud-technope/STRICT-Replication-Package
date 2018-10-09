public boolean accept(String url) {
    if (pattern == null) {
        pattern = Pattern.compile(StandardUtilities.globToRE(glob), Pattern.CASE_INSENSITIVE);
    }
    return pattern.matcher(url).matches();
}