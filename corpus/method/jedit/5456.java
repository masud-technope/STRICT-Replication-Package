@Override
public int getColumnCount() {
    if (ALL.equals(name))
        return 4;
    return 3;
}