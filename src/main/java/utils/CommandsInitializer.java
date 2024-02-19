package utils;

import commands.Init;

import java.util.HashMap;

public class CommandsInitializer {
    private HashMap<String, Runnable> commands;
    public CommandsInitializer(){
        commands = new HashMap<>();
        commands.put("init", new Init());
        // the rest of our commands -> "commit" = new Commit() .. etc
    }
    public Boolean isCommandExist(String key){
        return commands.containsKey(key);
    }
    public Runnable getValue(String key){
        if(!isCommandExist(key)){
            System.out.println("command not exist");
            return null;
        }
        return commands.get(key);
    }
}
