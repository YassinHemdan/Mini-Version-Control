package commands;


import picocli.CommandLine.Command;
import utils.Constants;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Command(
        name = "init",
        description = "initializing the repo"
)
public class Init implements Runnable{

    private static void createGitFolder(String path){
        File file = new File(path);
        if(!file.mkdir())
            throw new RuntimeException("cannot create .GIT folder");


        String[] git_sub_folders = Constants.GitMetaDataContent.split("\\|", 0);

        for(String folder : git_sub_folders){
            if(!new File(path + "/" + folder).mkdir())
                throw new RuntimeException("folder " + folder + " cannot be created");
        }
    }
    @Override
    public void run() {
        String path = System.getProperty("user.dir") + "/" + Constants.GitMetaDataDir;
        if(!Files.exists(Path.of(path)))
            createGitFolder(path);
        else
            System.out.println("Git repository already created.");

    }
}
