public String depsToString() {
    StringBuilder sb = new StringBuilder();
    for (Dependency dep : deps) {
        if ("plugin".equals(dep.what) && dep.pluginName != null) {
            sb.append(dep.pluginName).append('\n');
        }
    }
    return sb.toString();
}