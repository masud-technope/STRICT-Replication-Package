String compress(String path) {
    String original = path;
    if (previous.containsKey(path)) {
        return previous.get(path);
    }
    String bestPrefix = "/";
    String verifiedPrefix = bestPrefix;
    for (String tryPrefix : prefixMap.keySet()) {
        if (tryPrefix.length() < bestPrefix.length())
            continue;
        if (OperatingSystem.isWindows() && path.toLowerCase().startsWith(tryPrefix))
            bestPrefix = tryPrefix;
        else if (path.startsWith(tryPrefix)) {
            bestPrefix = tryPrefix;
        }
        if (!bestPrefix.equals(verifiedPrefix)) {
            String remainder = original.substring(bestPrefix.length());
            if (remainder.length() < 1 || remainder.startsWith(File.separator))
                verifiedPrefix = bestPrefix;
            else
                bestPrefix = verifiedPrefix;
        }
    }
    if (bestPrefix.length() > 1) {
        String remainder = original.substring(bestPrefix.length());
        String envvar = prefixMap.get(bestPrefix);
        if (envvar.equals("~"))
            path = envvar + remainder;
        else if (OperatingSystem.isWindows())
            path = '%' + envvar.toUpperCase() + '%' + remainder;
        else
            path = '$' + envvar + remainder;
    }
    previous.put(original, path);
    return path;
}