package dsw.GeRuMap.app.mapRepository.command;

import dsw.GeRuMap.app.AppCore;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.mapRepository.command.komande.MoveElementCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<AbstractCommand> commands = new ArrayList<>();

    private int currentCommand = 0;

    public void addCommand(AbstractCommand command){
        while(currentCommand < commands.size())
            commands.remove(currentCommand);
        commands.add(command);
        if(! (command instanceof MoveElementCommand))doCommand();
        else currentCommand++;
        System.out.println("dodata komanda");
    }

    public void doCommand() {
        if(currentCommand < commands.size()) {
            commands.get(currentCommand++).doCommand();
            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
        }
        if(currentCommand==commands.size()){
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
        }
    }
    public void undoCommand(){
        if(currentCommand > 0){
            MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
            commands.get(--currentCommand).undoCommand();
        }
        if(currentCommand==0){
            //ovo
            //AppCore.getInstance().getGui().enable

            MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
        }
    }

}
