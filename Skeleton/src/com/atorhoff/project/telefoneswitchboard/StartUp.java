package com.atorhoff.project.telefoneswitchboard;

import com.atorhoff.project.telefoneswitchboard.core.SwitchBoardEngineImpl;

public class StartUp {
    public static void main(String[] args) {

        SwitchBoardEngineImpl engine = new SwitchBoardEngineImpl();
        engine.start();

    }
}
