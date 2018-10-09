public boolean equals(Object obj) {
    if (obj instanceof Completion)
        return ((Completion) obj).text.equals(text);
    else
        return false;
}