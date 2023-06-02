package cm.sg.ClassRoster.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{
    Scanner sc = new Scanner(System.in);
    @Override
    public void print(String message) {
        System.out.println(message); //Print a given String to the console.
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String answer = sc.nextLine();
        return answer;
    }

    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true; //means we have an invalid input.
        int answer = 0;
        while(invalidInput){
            try{
                System.out.println(prompt);
                answer = Integer.parseInt(sc.nextLine());
                invalidInput = false;
            } catch (NumberFormatException e){
                System.out.println("Input error. Please try again."); //or : this.print
            }
        }
        return answer;

    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int answer;
        do{
            answer = readInt(prompt);
        } while (answer <min || answer > max); //continue to re-prompt if number is not in the range
        return answer;
    }

    @Override
    public double readDouble(String prompt) {
        while(true){
            try{
                return Double.parseDouble(this.readString(prompt));
            } catch(NumberFormatException e){
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double answer;
        do{
            answer = readDouble(prompt);
        } while (answer <min || answer > max);
        return answer;
    }

    @Override
    public float readFloat(String prompt) {
        while(true){
            try{
                return Float.parseFloat(this.readString(prompt));
            } catch (NumberFormatException e){
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float result;
        do {
            result = readFloat(prompt);
        } while (result < min || result > max);
        return result;
    }

    @Override
    public long readLong(String prompt) {
        while (true){
            try{
                long answer = Long.parseLong(this.readString(prompt));
                return answer;
            } catch (NumberFormatException e){
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long answer = 0;
        do{
            System.out.println(prompt);            //or answer = readLong(prompt);
            answer = Long.parseLong(sc.nextLine());
        } while (answer <min || answer > max);
        return answer;
    }
}
