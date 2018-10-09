private void insureNo(String modifier, String context) {
    if (hasModifier(modifier))
        throw new IllegalStateException(context + " cannot be declared '" + modifier + "'");
}