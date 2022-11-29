package dsw.GeRuMap.app.gui.controller;

public class MouseControler {

    private NewPojamAction pojamAction;
    private NewVezaAction vezaAction;
    private SelectAction selectAction;
    private BrisiElementAction brisiElementAction;
    private PodesavanjaAction podesavanjaAction;

    public MouseControler(){
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
