/* 
  * ============================================================================ 
  * Name      : ChargeResult.java
  * Part of     :  NEON
  * 
  * Copyright (c) 2007-2011 Nokia.  All rights reserved.
  * This material, including documentation and any related computer
  * programs, is protected by copyright controlled by Nokia.  All
  * rights are reserved.  Copying, including reproducing, storing,
  * adapting or translating, any or all of this material requires the
  * prior written consent of Nokia.  This material also contains
  * confidential information which may not be disclosed to others
  * without the prior written consent of Nokia.
 * 
  * ============================================================================
  */
package juice;

/**
 * 
 *
 */
public class ChargeResult {
    
    boolean successful;
    String declineMessage;

    /**
     * @param successful
     * @param declineMessage
     */
    public ChargeResult(boolean successful, String declineMessage) {
        super();
        this.successful = successful;
        this.declineMessage = declineMessage;
    }

    /**
     * @return
     */
    public boolean wasSuccessful() {
        return successful;
    }

    /**
     * @return
     */
    public String getDeclineMessage() {
        return declineMessage;
    }

}
