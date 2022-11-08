package dsw.GeRuMap.app.gui.controller;

public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private  DeleteProjectAction deleteProjectAction;
    private InfoAction infoAction;

    private ChangeNameAction changeNameAction;

    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        deleteProjectAction = new DeleteProjectAction();
        infoAction = new InfoAction();
        changeNameAction=new ChangeNameAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public DeleteProjectAction getDeleteProjectAction() {
        return deleteProjectAction;
    }

    public InfoAction getInfoAction(){
        return infoAction;
    }

    public ChangeNameAction getChangeNameAction(){ return changeNameAction;}
}
