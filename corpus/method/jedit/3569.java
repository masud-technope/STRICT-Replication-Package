//}}}
//{{{ getFontList() method
private static String[] getFontList() {
    String[] nameArray = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    List<String> nameVector = new ArrayList<String>(nameArray.length);
    for (int i = 0; i < nameArray.length; i++) {
        int j;
        for (j = 0; j < HIDEFONTS.length; j++) {
            if (nameArray[i].contains(HIDEFONTS[j]))
                break;
        }
        if (j == HIDEFONTS.length)
            nameVector.add(nameArray[i]);
    }
    String[] _array = new String[nameVector.size()];
    return nameVector.toArray(_array);
}