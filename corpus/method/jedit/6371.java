@Override
public int hashCode() {
    int result = 31 * clazz.hashCode() + name.hashCode();
    return result;
}