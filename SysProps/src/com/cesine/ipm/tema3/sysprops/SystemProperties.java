package com.cesine.ipm.tema3.sysprops;

/* This file was created by Nokia Developer's Suite for J2ME(TM) */

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class SystemProperties extends MIDlet implements CommandListener {
  private static final String[] SYSPROPLISTS = {
      "CLDC&MIDP", "Optional packages", "MMAPI", "Bluetooth API",
      "FileConnection API", "WMA", "SATSA", "Other", "MIDlet"};
  private static final String[] CLDC_MIDPPROPS = {
      "microedition.profiles", "microedition.configuration", "microedition.locale",
      "microedition.platform", "microedition.encoding", "microedition.commports",
      "microedition.hostname", "microedition.jtwi.version"};
  private static final String[] OPT_SYSPROPS = {
      "microedition.media.version", "microedition.pim.version",
      "microedition.io.file.FileConnection.version", "microedition.m3g.version",
      "microedition.location.version", "microedition.global.version",
      "microedition.chapi.version", "microedition.sip.version"};
  private static final String[] MMAPI_SYSPROPS = {
      "supports.mixing", "supports.audio.capture", "supports.video.capture",
      "supports.recording", "audio.encodings", "video.encodings",
      "video.snapshot.encodings", "streamable.contents"};
  private static final String[] BT_SYSPROPS = {
	  "bluetooth.api.version", "bluetooth.l2cap.receiveMTU.max",
	  "bluetooth.connected.devices.max", "bluetooth.connected.inquiry",
	  "bluetooth.connected.page", "bluetooth.connected.inquiry.scan",
	  "bluetooth.connected.page.scan", "bluetooth.master.switch",
	  "bluetooth.sd.trans.max", "bluetooth.sd.attr.retrievable.max"};
  private static final String[] FILE_API_SYSPROPS = { "fileconn.dir.photos",
      "fileconn.dir.videos", "fileconn.dir.tones", "fileconn.dir.memorycard",
      "fileconn.dir.private", "fileconn.dir.photos.name", "fileconn.dir.videos.name",
      "fileconn.dir.tones.name", "fileconn.dir.memorycard.name", "file.separator"};
  private static final String[] WMA_SYSPROPS = {
      "wireless.messaging.sms.smsc"};
  private static final String[] SATSA_SYSPROPS = {
      "microedition.smartcardslots"};
  private static final String[] OTHER_SYSPROPS = {
      "com.nokia.mid.dateformat", "com.nokia.mid.timeformat",
      "com.nokia.network.access", "com.nokia.mid.imei"};
  private static final String[] MIDLET_SYSPROPS = {"MIDlet-1","MIDlet-Jar-Size",
	"MIDlet-Jar-URL","MIDlet-Name","MIDlet-Vendor","MIDlet-Version",
        "MicroEdition-Configuration","MicroEdition-Profile","Which-Locale"};
  private List list;
  private SysPropForm cldcmidpform;
  private SysPropForm optform;
  private SysPropForm mmapiform;
  private SysPropForm btform;
  private SysPropForm fileapiform;
  private SysPropForm wmaform;
  private SysPropForm satsaform;
  private SysPropForm otherform;
  private SysPropForm midletform;
  private Command exitCommand;
  protected boolean bt = false;
  protected boolean app = false;

  public SystemProperties() {
    list = new List("System properties", List.IMPLICIT, SYSPROPLISTS, null);
    exitCommand = new Command("Exit", Command.EXIT, 1);
    list.addCommand(exitCommand);
    list.setCommandListener(this);
    Display.getDisplay(this).setCurrent(list);
  }

  protected void startApp() throws MIDletStateChangeException {
  }

  protected void pauseApp() {
  }

  protected void destroyApp(boolean p1) {
  }

  public void commandAction(Command c, Displayable d) {
    if (c == List.SELECT_COMMAND) {
      int index = list.getSelectedIndex();
      if (index == 0) {
        cldcmidpform = new SysPropForm(SYSPROPLISTS[0], this, CLDC_MIDPPROPS);
        Display.getDisplay(this).setCurrent(cldcmidpform);
      }
      if (index == 1) {
        optform = new SysPropForm(SYSPROPLISTS[1], this, OPT_SYSPROPS);
        Display.getDisplay(this).setCurrent(optform);
      }
      if (index == 2) {
        mmapiform = new SysPropForm(SYSPROPLISTS[2], this, MMAPI_SYSPROPS);
        Display.getDisplay(this).setCurrent(mmapiform);
      }
      if (index == 3) {
        bt = true;
        btform = new SysPropForm(SYSPROPLISTS[3], this, BT_SYSPROPS);
        Display.getDisplay(this).setCurrent(btform);
      }
      if (index == 4) {
        fileapiform = new SysPropForm(SYSPROPLISTS[4], this, FILE_API_SYSPROPS);
        Display.getDisplay(this).setCurrent(fileapiform);
      }
      if (index == 5) {
        wmaform = new SysPropForm(SYSPROPLISTS[5], this, WMA_SYSPROPS);
        Display.getDisplay(this).setCurrent(wmaform);
      }
      if (index == 6) {
        satsaform = new SysPropForm(SYSPROPLISTS[6], this, SATSA_SYSPROPS);
        Display.getDisplay(this).setCurrent(satsaform);
      }
      if (index == 7) {
        otherform = new SysPropForm(SYSPROPLISTS[7], this, OTHER_SYSPROPS);
        Display.getDisplay(this).setCurrent(otherform);
      }
      if (index == 8) {
        this.app = true;
        midletform = new SysPropForm(SYSPROPLISTS[8], this, MIDLET_SYSPROPS);
        Display.getDisplay(this).setCurrent(midletform);
      }
    }
    if (c == exitCommand) {
      quitApp();
    }
  }

  public void quitApp() {
    destroyApp(true);
    notifyDestroyed();
  }

  protected void showList() {
    Display.getDisplay(this).setCurrent(list);
  }
}
