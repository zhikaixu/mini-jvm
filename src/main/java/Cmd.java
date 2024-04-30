import com.beust.jcommander.*;

import java.util.List;

public class Cmd {
    @Parameter(names = {"-?", "-help"}, description = "print help message", help = true, order = 1)
    boolean helpFlag = false;

    @Parameter(names = "-version", description = "print the version", order = 2)
    boolean versionFlag = false;

    @Parameter(names = {"-cp", "-classpath"}, description = "classpath", order = 3)
    String classPath;

    @Parameter(description = "main class and args")
    List<String> mainClassAndArgs;

    boolean ok = false;

    public String getMainClass() {
        if (mainClassAndArgs != null && !mainClassAndArgs.isEmpty()) {
            return mainClassAndArgs.get(0);
        }
        return null;
    }

    public List<String> getArgs() {
        if (mainClassAndArgs != null && !mainClassAndArgs.isEmpty()) {
            return mainClassAndArgs.subList(0, mainClassAndArgs.size());
        }
        return null;
    }

    public static Cmd parse(String[] argv) {
        Cmd args = new Cmd();
        JCommander.newBuilder().addObject(args).build().parse(argv);
        args.ok = true;
        return args;
    }
}
