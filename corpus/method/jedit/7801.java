//}}}
//{{{ equals() method
@Override
public boolean equals(Object obj) {
    if (!(obj instanceof Keymap))
        return false;
    Keymap keymap = (Keymap) obj;
    return name.equals(keymap.toString());
}