package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.controller.editorActions.*;
import dsw.GeRuMap.app.gui.controller.update.PodesiAction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private  DeleteProjectAction deleteProjectAction;
    private InfoAction infoAction;
    private ChangeNameAction changeNameAction;

    private NewPojamAction pojamAction;
    private NewVezaAction vezaAction;
    private SelectAction selectAction;
    private BrisiElementAction brisiElementAction;
    private PodesavanjaAction podesavanjaAction;


    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        deleteProjectAction = new DeleteProjectAction();
        infoAction = new InfoAction();
        changeNameAction=new ChangeNameAction();
        pojamAction = new NewPojamAction();
        vezaAction = new NewVezaAction();
        selectAction = new SelectAction();
        brisiElementAction = new BrisiElementAction();
        podesavanjaAction = new PodesavanjaAction();
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

    public ChangeNameAction getChangeNameAction(){
        return changeNameAction;
    }
}
