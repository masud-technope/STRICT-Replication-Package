private void writeClasspath(List classpath, List extraClasspath, Node appendTo) {
    writeKey("ClassPath", appendTo);
    classpath.addAll(extraClasspath);
    writeArray(classpath, appendTo);
}