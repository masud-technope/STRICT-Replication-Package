private static String layoutToFile(String baseName, int viewIndex) {
    StringBuilder name = new StringBuilder(baseName);
    if (viewIndex != NO_VIEW_INDEX)
        name.append("-view").append(viewIndex);
    name.append(".xml");
    return name.toString();
}