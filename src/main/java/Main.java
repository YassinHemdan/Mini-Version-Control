import commands.Init;
import picocli.CommandLine;
import utils.CommandsInitializer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        CommandsInitializer commands = new CommandsInitializer();

        String user_command = "";
        while(true){

            user_command = scan.nextLine();
            if(user_command.equals("exit"))
                break;
            String[] command_arr = user_command.split("\\s+");

            if(!command_arr[0].equals("git"))
                System.out.println("invalid command. Try again using git command");
            else{
                if(commands.isCommandExist(command_arr[1]))
                    new CommandLine(commands.getValue(command_arr[1])).
                            execute(Arrays.copyOfRange(command_arr, 1, command_arr.length - 1));
                else
                    System.out.println("git " + command_arr[1] + " is not recognized." +
                            " use git --help to list all the valid git commands");
            }
        }
    }
}
