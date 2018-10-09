public static String buildToVersion(String build) {
    if (build.length() != 11)
        return "<unknown version: " + build + '>';
    // First 2 chars are the major version number
    int major = Integer.parseInt(build.substring(0, 2));
    // Second 2 are the minor number
    int minor = Integer.parseInt(build.substring(3, 5));
    // Then the pre-release status
    int beta = Integer.parseInt(build.substring(6, 8));
    // Finally the micro version number
    int micro = Integer.parseInt(build.substring(9, 11));
    return major + "." + minor + (beta != 99 ? "pre" + beta : "." + micro);
}