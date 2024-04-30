import com.beust.jcommander.JCommander;

public class Main {
    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            JCommander jCommander = JCommander.newBuilder().addObject(cmd).build();
            jCommander.usage();
            return;
        }

        if (cmd.versionFlag) {
            System.out.println("java version \"1.8.0\"");
            return;
        }

        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        System.out.printf("classpath:%s class: %s args: %s", cmd.classPath, cmd.getMainClass(), cmd.getArgs());
    }
}
