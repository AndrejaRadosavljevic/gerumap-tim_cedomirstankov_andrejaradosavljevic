package dsw.GeRuMap.app.gui.state;

import dsw.GeRuMap.app.gui.state.concrete.BrisiElementState;
import dsw.GeRuMap.app.gui.state.concrete.NewPojamState;
import dsw.GeRuMap.app.gui.state.concrete.NewVezaState;
import dsw.GeRuMap.app.gui.state.concrete.SelectState;

public class StateManager {

    private State currentState;

    private BrisiElementState brisiElementState;

    private NewPojamState newPojamState;

    private NewVezaState newVezaState;

    private SelectState selectState;

    public StateManager(){
        initstates();
    }

    private void initstates(){
        brisiElementState=new BrisiElementState();
        newPojamState=new NewPojamState();
        newVezaState=new NewVezaState();
        selectState=new SelectState();
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
}
