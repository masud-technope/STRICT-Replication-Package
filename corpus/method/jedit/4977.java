//{{{ characters() method
@Override
public void characters(char[] ch, int start, int length) {
    if (inRegister)
        charData.append(ch, start, length);
//}}}
}