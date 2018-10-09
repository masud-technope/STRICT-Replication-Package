//{{{ record() method
public void record(int repeat, String code) {
    if (repeat == 1)
        record(code);
    else {
        record("for(int i = 1; i <= " + repeat + "; i++)\n" + "{\n" + code + '\n' + '}');
    }
//}}}
}