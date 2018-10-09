private static JCheckBoxList.Entry createEntry(Object obj) {
    if (obj instanceof JCheckBoxList.Entry)
        return (JCheckBoxList.Entry) obj;
    else
        return new JCheckBoxList.Entry(false, obj);
}