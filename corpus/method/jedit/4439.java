//{{{ CloseBracketIndentRule constructor
public  CloseBracketIndentRule(char closeBracket, boolean aligned) {
    super(TextUtilities.getComplementaryBracket(closeBracket, null), closeBracket);
    this.aligned = aligned;
}