package lambda;

public class MethodAssign {
    private int intValue = 1;

    private String stringValue = "hello world";

    private boolean boolValue = intValue == 1;

    /**
     * what about aBlockOfCode = public void doSomething() { // do something code }
     * aBlock = () -> { // do something code }
     */

    private LambdaInterface aBlockOfCode = () -> {
        if (this.boolValue) {
            System.out.println(this.stringValue);
        }
    };
}
