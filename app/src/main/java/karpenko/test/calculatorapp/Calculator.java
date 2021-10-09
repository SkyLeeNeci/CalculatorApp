package karpenko.test.calculatorapp;


public class Calculator {

    private int firstNumber;
    private int secondNumber;
    private State state;

    private StringBuilder input = new StringBuilder();

    private int actionCheck;

    private enum State{
        firstNumber,
        secondNumber,
        result
    }

    public Calculator(){
        state = State.firstNumber;
    }

    public void numPressed(int numbers){

        if (state == State.result){
            state = State.firstNumber;
            input.setLength(0);
        }

        if (input.length() < 9) {
            switch (numbers){
                case R.id.zero:
                    if (input.length() != 0){
                        input.append("0");
                    }break;
                case R.id.one:
                    input.append("1");break;
                case R.id.two:
                    input.append("2");break;
                case R.id.three:
                    input.append("3");break;
                case R.id.four:
                    input.append("4");break;
                case R.id.fife:
                    input.append("5");break;
                case R.id.six:
                    input.append("6");break;
                case R.id.seven:
                    input.append("7");break;
                case R.id.eight:
                    input.append("8");break;
                case R.id.nine:
                    input.append("9");break;
            }
        }
    }

    public void onActionPressed(int actionBtns){

        if(actionBtns == R.id.equals && state == State.secondNumber){
            secondNumber = Integer.parseInt(input.toString());
            state = State.result;
            input.setLength(0);
            switch (actionCheck){
                case R.id.plus:
                    actionCheck = R.id.plus;
                    input.append(firstNumber + secondNumber);
                    break;
                case R.id.minus:
                    actionCheck = R.id.minus;
                    input.append(firstNumber - secondNumber);
                    break;
                case R.id.div:
                    actionCheck = R.id.div;
                    input.append(firstNumber / secondNumber);
                    break;
                case R.id.multiplication:
                    actionCheck = R.id.multiplication;
                    input.append(firstNumber * secondNumber);
                    break;
            }
        }else if (input.length() > 0 && state == State.firstNumber){
            firstNumber = Integer.parseInt(input.toString());
            state = State.secondNumber;
            input.setLength(0);
        }

        switch (actionBtns){
            case R.id.plus:
                actionCheck = R.id.plus;
                break;
            case R.id.minus:
                actionCheck = R.id.minus;
                break;
            case R.id.div:
                actionCheck = R.id.div;
                break;
            case R.id.multiplication:
                actionCheck = R.id.multiplication;
                break;

        }
    }

    public String getText(){
        return input.toString();
    }
}
