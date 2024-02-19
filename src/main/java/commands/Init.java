package commands;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Command(
        name = "init",
        description = "initializing the repo"
)
public class Init implements Runnable{
    private static final String GitMetaDataDir = ".GIT";
    private static final String GitMetaDataContent = "objects|refs";
    private static void createGitFolder(String path){
        File file = new File(path);
        if(!file.mkdir())
            throw new RuntimeException("cannot create .GIT folder");


        String[] git_sub_folders = GitMetaDataContent.split("\\|", 0);

        for(String folder : git_sub_folders){
            if(!new File(path + "/" + folder).mkdir())
                throw new RuntimeException("folder " + folder + " cannot be created");
        }
    }
    @Override
    public void run() {
        String path = System.getProperty("user.dir") + "/" + GitMetaDataDir;
        if(!Files.exists(Path.of(path)))
            createGitFolder(path);
        else
            System.out.println("Git repository already created.");

    }
}
