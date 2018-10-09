public boolean hasModifier(String name) {
    if (modifiers == null)
        modifiers = new Hashtable();
    return modifiers.get(name) != null;
}