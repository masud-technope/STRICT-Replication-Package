//{{{ equals() method
public boolean equals(Object o) {
    return o instanceof Remove && ((Remove) o).jar.equals(jar);
//}}}
}