public boolean equals(Object o) {
    if (o instanceof Descriptor) {
        Descriptor d = (Descriptor) o;
        return d.clazz.equals(clazz) && d.name.equals(name);
    } else
        return false;
}