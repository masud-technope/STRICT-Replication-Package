public String toString() {
    return "LHS: " + ((field != null) ? "field = " + field.toString() : "") + (varName != null ? " varName = " + varName : "") + (nameSpace != null ? " nameSpace = " + nameSpace.toString() : "");
}