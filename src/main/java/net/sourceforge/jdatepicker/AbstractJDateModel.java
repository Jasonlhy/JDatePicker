/**
Copyright 2004 Juan Heyns. All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are
permitted provided that the following conditions are met:

   1. Redistributions of source code must retain the above copyright notice, this list of
      conditions and the following disclaimer.

   2. Redistributions in binary form must reproduce the above copyright notice, this list
      of conditions and the following disclaimer in the documentation and/or other materials
      provided with the distribution.

THIS SOFTWARE IS PROVIDED BY JUAN HEYNS ``AS IS'' AND ANY EXPRESS OR IMPLIED
WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL JUAN HEYNS OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

The views and conclusions contained in the software and documentation are those of the
authors and should not be interpreted as representing official policies, either expressed
or implied, of Juan Heyns.
*/
package net.sourceforge.jdatepicker;

import java.util.HashSet;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created 18 April 2010
 * 
 * @author Juan Heyns
 *
 * @param <T>
 */
public abstract class AbstractJDateModel<T> implements DateModel<T> {
	
	private HashSet<ChangeListener> changeListeners;

	protected AbstractJDateModel() {
		changeListeners = new HashSet<ChangeListener>();		
	}
	
	public void addChangeListener(ChangeListener changeListener) {
		changeListeners.add(changeListener);
	}

	public void removeChangeListener(ChangeListener changeListener) {
		changeListeners.remove(changeListener);
	}

	/**
	 * Called internally when changeListeners should be notified.
	 */
	protected void fireChangeEvent() {
		for (ChangeListener changeListener : changeListeners) {
			changeListener.stateChanged(new ChangeEvent(this));
		}
	}
	
}