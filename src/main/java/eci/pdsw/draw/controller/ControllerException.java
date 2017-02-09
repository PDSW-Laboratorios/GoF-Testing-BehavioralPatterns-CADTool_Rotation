/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.pdsw.draw.controller;

/**
 *
 * @author skinman95
 */
public class ControllerException extends Exception{
    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }

    public ControllerException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
}
