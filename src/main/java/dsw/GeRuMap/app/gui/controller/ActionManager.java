package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.controller.editorActions.*;
import dsw.GeRuMap.app.gui.controller.update.PodesiAction;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

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
    private MoveAction moveAction;

    private ZoomInAction zoomInAction;

    private ZoomOutAction zoomOutAction;
    private UndoAction undoAction;

    private RedoAction redoAction;

    private SaveAction saveAction;
    private SaveTemplateAction saveTemplateAction;
    private SaveAsPngAction saveAsPngAction;

    private OpenAction openAction;


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
        moveAction = new MoveAction();
        undoAction=new UndoAction();
        redoAction=new RedoAction();
        saveAction=new SaveAction();
        openAction=new OpenAction();
        zoomInAction=new ZoomInAction();
        zoomOutAction=new ZoomOutAction();
        saveTemplateAction = new SaveTemplateAction();
        saveAsPngAction = new SaveAsPngAction();
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

    public SaveTemplateAction getSaveTemplateAction() {
        return saveTemplateAction;
    }
}
