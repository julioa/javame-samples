package com.cesine.ipm.tema3.sysprops;

/* This file was created by Nokia Developer's Suite for J2ME(TM) */

import javax.microedition.lcdui.*;
import javax.bluetooth.LocalDevice;

public class SysPropForm extends Form implements CommandListener {
  private Command backCommand;
  private Command exitCommand;
  private SystemProperties midlet;

  public SysPropForm(String title, SystemProperties midlet, String[] list) {
    super(title);
    this.midlet = midlet;
    backCommand = new Command("Back", Command.BACK, 1);
    exitCommand = new Command("Exit", Command.EXIT, 1);
    addCommand(backCommand);
    addCommand(exitCommand);
    setCommandListener(this);

    for (int i = 0; i < list.length; i++) {
      append(list[i] + ":\n");
      if (midlet.bt) {
        append(LocalDevice.getProperty(list[i]) + "\n");
      } else if (midlet.app) {
          append(midlet.getAppProperty(list[i]) + "\n");
      } else {
          append(System.getProperty(list[i]) + "\n");
      }
    }
  }

  public void commandAction(Command c, Displayable d) {
    if (c == backCommand) {
      midlet.showList();
      midlet.bt = false;
      midlet.app = false;
    }
    if (c == exitCommand) {
      midlet.quitApp();
    }
  }
}
