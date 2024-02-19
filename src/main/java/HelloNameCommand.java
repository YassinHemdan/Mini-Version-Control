import java.util.Scanner;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;
@Command(
        name = "helloName",
        description = "It prints hello [name]"
)
public class HelloNameCommand implements Runnable{
    @Parameters(index = "0", description = "the name to print")
    private String name;
    @Option(names = {"-c", "--caps"}, description = "print the name in all capital")
    private boolean allCaps = false;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String command1 = scan.next();
        String command2 = scan.next();

        String[] myArgs = new String[2];
        myArgs[0] = command1;
        myArgs[1] = command2;
        new CommandLine(new HelloNameCommand()).execute("yassin=-c");
    }
    @Override
    public void run() {
        System.out.println("hello " + (allCaps ? name.toUpperCase() : name));
    }
}
