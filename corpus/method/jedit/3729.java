public  Key(String modifiers, int key, char input) {
    this.modifiers = modifiers;
    this.key = key;
    this.input = input;
    hashCode = key + input;
}