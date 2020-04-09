package ru.pasha.pt.lab2;

import javax.xml.bind.JAXB;
import java.io.File;

public class StateManager {
    private static final String STATE_FILENAME = "state.xml";
    private static final File file = new File(STATE_FILENAME);

    private StateManager(){}

    public static State getState(){
        return JAXB.unmarshal(file, State.class);
    }

    public static void setState(State state){
        JAXB.marshal(state, file);
    }

}
