package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.controller.editorActions.*;

public class MouseController {

    private NewPojamAction pojamAction;
    private NewVezaAction vezaAction;
    private SelectAction selectAction;
    private BrisiElementAction brisiElementAction;
    private PodesavanjaAction podesavanjaAction;

    public MouseController(){
        initialiseActions();
    }

    private void initialiseActions(){
        pojamAction = new NewPojamAction();
        vezaAction = new NewVezaAction();
        selectAction = new SelectAction();
        brisiElementAction = new BrisiElementAction();
        podesavanjaAction = new PodesavanjaAction();
    }

}
