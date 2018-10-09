//{{{ OpenBracketIndentRule constructor
public  OpenBracketIndentRule(char openBracket, boolean aligned) {
    super(openBracket, TextUtilities.getComplementaryBracket(openBracket, null));
    this.aligned = aligned;
}