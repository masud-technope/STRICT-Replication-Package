@Override
public void characters(char[] ch, int start, int length) {
    if (inEntry)
        charData.append(ch, start, length);
}