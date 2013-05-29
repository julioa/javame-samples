/* License
 * 
 * Copyright 1994-2004 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *  
 *  * Redistribution of source code must retain the above copyright notice,
 *      this list of conditions and the following disclaimer.
 * 
 *  * Redistribution in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *  
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MICROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *  
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility. 
 */

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class SimpleGameCanvas
    extends GameCanvas
    implements Runnable {
  private volatile boolean mTrucking;
  private long mFrameDelay;
  
  private int mX, mY;
  private int mState;
  
  public SimpleGameCanvas() {
    super(false);
    mX = getWidth() / 2;
    mY = getHeight() / 2;
    mState = 0;
    mFrameDelay = 20;
  }
  
  public void start() {
    mTrucking = true;
    Thread t = new Thread(this);
    t.start();
  }
  
  public void stop() { mTrucking = false; }
  
  public void run() {
    Graphics g = getGraphics();
    
    while (mTrucking == true) {
      tick();
      input();
      render(g);
      try { Thread.sleep(mFrameDelay); }
      catch (InterruptedException ie) { stop(); }
    }
  }
  
  private void tick() {
    mState = (mState + 1) % 20;
  }
  
  private void input() {
    int keyStates = getKeyStates();
    if ((keyStates & LEFT_PRESSED) != 0)
      mX = Math.max(0, mX - 1);
    if ((keyStates & RIGHT_PRESSED) != 0)
      mX = Math.min(getWidth(), mX + 1);
    if ((keyStates & UP_PRESSED) != 0)
      mY = Math.max(0, mY - 1);
    if ((keyStates & DOWN_PRESSED) != 0)
      mY = Math.min(getHeight(), mY + 1);
  }
  
  private void render(Graphics g) {
    g.setColor(0xffffff);
    g.fillRect(0, 0, getWidth(), getHeight());
    
    g.setColor(0x0000ff);
    g.drawLine(mX, mY, mX - 10 + mState, mY - 10);
    g.drawLine(mX, mY, mX + 10, mY - 10 + mState);
    g.drawLine(mX, mY, mX + 10 - mState, mY + 10);
    g.drawLine(mX, mY, mX - 10, mY + 10 - mState);
    
    flushGraphics();
  }
}
