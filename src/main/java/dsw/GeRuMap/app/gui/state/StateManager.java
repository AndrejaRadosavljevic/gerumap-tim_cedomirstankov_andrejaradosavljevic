package dsw.GeRuMap.app.gui.state;

import dsw.GeRuMap.app.gui.state.concrete.*;

public class StateManager {

    private State currentState;

    private BrisiElementState brisiElementState;

    private NewPojamState newPojamState;

    private NewVezaState newVezaState;

    private SelectState selectState;
    private MoveState moveState;

    public StateManager(){
        initstates();
    }

    private void initstates(){
        brisiElementState=new BrisiElementState();
        newPojamState=new NewPojamState();
        newVezaState=new NewVezaState();
        selectState=new SelectState();
        moveState = new MoveState();
        currentState=selectState;
    }

    public State getCurrent(){
        return currentState;
    }

    public void setBrisiElementState(){
        currentState=brisiElementState;
    }

    public void setNewPojamState(){
        currentState=newPojamState;
    }

    public void setNewVezaState(){
        currentState=newVezaState;
    }

    public void setSelectState(){
        currentState=selectState;
    }

    public void setMoveState() {
        currentState = moveState;
    }
}
