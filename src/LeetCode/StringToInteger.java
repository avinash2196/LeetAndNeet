package LeetCode;

public class StringToInteger {


    public int myAtoi2(String s) {
        StateMachine Q = new StateMachine();

        for(int i=0; i<s.length() && Q.getState()!=State.NonDigit; i++){
            Q.transition(s.charAt(i));
        }
        return Q.getInteger();
    }
    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;
        int len = s.length();
        int index = 0;
        while (index < len && s.charAt(index) == ' ') { //move ahead for spaces
            index++;
        }
        if (index < len && s.charAt(index) == '+') { // for positive sign
            index++;
        } else if (index < len && s.charAt(index) == '-') { //for negative sign
            index++;
            sign = -1;
        }
        while (index < len && Character.isDigit(s.charAt(index))) { //for digits
            int digit = s.charAt(index) - '0';
            if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) { // over flow condition checks
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }

        return sign * result;
    }
}
enum State{
    Start,
    Digit,
    Sign,
    NonDigit
}
class StateMachine{
    private State currentState;
    private int result;
    private int sign;

    public StateMachine(){
        currentState = State.Start;
        result = 0;
        sign = 1;
    }
    //transition to state Sign
    private void toStateSign(char ch){
        sign = ( ch == '+' ) ? 1 : -1;
        currentState = State.Sign;
    }
    //transition to state Digit
    private void toDigitState(char ch){
        int digit = ch - '0';
        currentState = State.Digit;
        appendResult(digit);
    }
    //transition to state NonDigit ie. dead state
    private void toNonDigit(){
        currentState = State.NonDigit;
    }
    //Append result
    private void appendResult(int digit){
        if(
                (result > Integer.MAX_VALUE/10)||
                        ( result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)
        ){
            result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            sign = 1;
            toNonDigit();
        }else{
            result = result * 10 + digit;
        }
    }

    //main state transition function
    public void transition(char ch){
        if(currentState == State.Start){
            if( ch == ' '){
                //stay in same state
                return;
            }
            else if ( ch == '-' || ch == '+'){
                toStateSign(ch);
            }
            else if (Character.isDigit(ch)){
                toDigitState(ch);
            }else{
                toNonDigit();
            }
        }else if ( currentState == State.Digit || currentState == State.Sign ){
            if(Character.isDigit(ch)){
                toDigitState(ch);
            }else{
                toNonDigit();
            }
        }
    }

    public int getInteger(){
        return sign * result;
    }
    public State getState(){
        return currentState;
    }

}