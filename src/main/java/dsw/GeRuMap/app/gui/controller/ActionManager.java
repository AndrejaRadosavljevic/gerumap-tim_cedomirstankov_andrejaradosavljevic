package dsw.GeRuMap.app.gui.controller;

public class ActionManager {

    private ExitAction exitAction;

    private NewProjectAction newProjectAction;

    private InfoAction infoAction;

    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        infoAction = new InfoAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public InfoAction getInfoAction(){
        return infoAction;
    }
}
